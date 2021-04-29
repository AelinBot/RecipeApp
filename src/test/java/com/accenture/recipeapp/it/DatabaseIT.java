package com.accenture.recipeapp.it;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.repository.CommentRepository;
import com.accenture.recipeapp.repository.RecipeRepository;
import com.accenture.recipeapp.service.RecipeService;
import com.accenture.recipeapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DatabaseIT {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    CommentRepository commentRepository;

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
        Set<Comment> comments = commentRepository.findByRecipe_Id(8L);

        assertEquals(1, comments.size());
    }
}
