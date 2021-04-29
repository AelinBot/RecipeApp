package com.accenture.recipeapp.it;

import com.accenture.recipeapp.controller.RecipeController;
import com.accenture.recipeapp.dto.RecipeDto;
import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.repository.CommentRepository;
import com.accenture.recipeapp.security.SecurityConfig;
import com.accenture.recipeapp.service.RecipeService;
import com.accenture.recipeapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DatabaseIT {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeController recipeController;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    SecurityConfig securityConfig;

    @Test
    void getRecipeTest() {
        Recipe recipe = recipeService.getRecipeById(8L);

        assertEquals(8L, recipe.getId());
        assertEquals("panda", recipe.getUser().getUsername());
        assertEquals("Test", recipe.getTitle());
        assertEquals("Database test", recipe.getRecipeBody());
    }

    @Test
    void getUserTest() {
        UserDetails userTest = userService.loadUserByUsername("panda");

        assertEquals("panda", userTest.getUsername());
    }

    @Test
    void getCommentsByRecipeIdTest() {
        Set<Comment> comments = commentRepository.findByRecipeId(8L);

        assertEquals(1, comments.size());
    }

    @Test
    void updateRecipeTest() {
        RecipeDto newRecipe = new RecipeDto();
        newRecipe.setTitle("New title");
        newRecipe.setRecipeBody("New body");

        User user = userService.getUserByUsername("panda");

        recipeController.updateRecipe(1L, newRecipe, user);
        Recipe recipe = recipeService.getRecipeById(1L);
        assertEquals("New title", recipe.getTitle());
    }
}
