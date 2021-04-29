package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.entity.User;
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

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private RecipeService recipeService;

    @Test
    void showProfilePageTest() throws Exception {
        mockMvc.perform(get("/user/profile").with(user(TestData.getUser())))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"));
    }

    @Test
    void findUserProfileWhenUserNotExistTest() throws Exception {
        when(userService.getUserByUsername(anyString())).thenReturn(TestData.getUser());
        when(recipeService.getAllRecipeByUser(anyLong())).thenReturn(TestData.getRecipes());

        mockMvc.perform(get("/user/TestUsername").with(user(TestData.getUser()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", TestData.TEST_USERNAME))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/user/profile"));
    }

    @Test
    void changeUserPasswordTest() throws Exception {
        when(userService.updateUserPassword(any(User.class), anyString())).thenReturn(TestData.getUser());

        mockMvc.perform(post("/user/update/password").with(user(TestData.getUser()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("password", TestData.TEST_PASSWORD))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/user/profile"));
    }
}
