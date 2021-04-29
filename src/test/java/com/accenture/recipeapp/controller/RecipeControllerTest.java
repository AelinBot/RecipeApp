package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.dto.RecipeDto;
import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.mapper.MapCommentDtoToEntity;
import com.accenture.recipeapp.mapper.MapRecipeDtoToEntity;
import com.accenture.recipeapp.service.CommentService;
import com.accenture.recipeapp.service.RecipeService;
import com.accenture.recipeapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private CommentService commentService;

    @MockBean
    private MapCommentDtoToEntity mapCommentDtoToEntity;

    @MockBean
    private MapRecipeDtoToEntity mapRecipeDtoToEntity;

    @Test
    void getAllRecipesTest() throws Exception {
        mockMvc.perform(get("/recipe/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes"));
    }

    @Test
    void getSingleRecipeTest() throws Exception {
        when(recipeService.getRecipeById(anyLong())).thenReturn(TestData.getRecipe());
        when(recipeService.getAllComments(anyLong())).thenReturn(TestData.getComments());

        mockMvc.perform(get("/recipe/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe"));
    }

    @Test
    void createRecipeTest() throws Exception {
        mockMvc.perform(get("/recipe/new").with(user(TestData.getUser())))
                .andExpect(status().isOk())
                .andExpect(view().name("new-recipe"));
    }

    @Test
    void postRecipeTest() throws Exception {
        when(mapRecipeDtoToEntity.mapRecipeToEntity(any(RecipeDto.class))).thenReturn(TestData.getRecipe());
        when(recipeService.saveRecipe(any(Recipe.class), any(User.class))).thenReturn(TestData.getRecipe());

        mockMvc.perform(post("/recipe").with(user(TestData.getUser()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", TestData.TEST_TITLE)
                .param("recipeBody", TestData.TEST_RECIPE_BODY))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/all"));
    }

    @Test
    void editRecipeTest() throws Exception {
        when(mapRecipeDtoToEntity.mapRecipeToEntity(any(RecipeDto.class))).thenReturn(TestData.getRecipe());
        when(recipeService.getRecipeById(anyLong())).thenReturn(TestData.getRecipe());

        mockMvc.perform(get("/recipe/update/1").with(user(TestData.getUser())))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-recipe"));
    }

    @Test
    void deleteRecipeTest() throws Exception {
        when(mapRecipeDtoToEntity.mapRecipeToEntity(any(RecipeDto.class))).thenReturn(TestData.getRecipe());
        when(recipeService.getRecipeById(anyLong())).thenReturn(TestData.getRecipe());
        doNothing().when(recipeService).deleteRecipeById(anyLong());

        mockMvc.perform(get("/recipe/delete/1").with(user(TestData.getUser())))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/all"));
    }

    @Test
    void addCommentTest() throws Exception {
        when(recipeService.getRecipeById(anyLong())).thenReturn(TestData.getRecipe());
        when(commentService.saveComment(any(Comment.class))).thenReturn(TestData.getComment());

        mockMvc.perform(post("/recipe/1/comment")
                .with(user(TestData.getUser()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", TestData.TEST_COMMENT))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/1"));
    }

    @Test
    void addCommentWithNoUserTest() throws Exception {
        mockMvc.perform(post("/recipe/1/comment"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    void deleteCommentTest() throws Exception {
        when(commentService.getCommentById(anyLong())).thenReturn(TestData.getComment());
        doNothing().when(commentService).deleteComment(anyLong());

        mockMvc.perform(get("/recipe/1/comment/delete/1").with(user(TestData.getUser())))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/1"));
    }
}
