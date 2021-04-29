package com.accenture.recipeapp.service;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.repository.CommentRepository;
import com.accenture.recipeapp.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    RecipeService recipeService;

    private Recipe recipe;
    private Comment comment;
    private Set<Recipe> recipeSet;
    private List<Recipe> recipeList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        recipe = TestData.getRecipe();
        comment = TestData.getComment();
        recipeSet = TestData.getRecipes();
    }

    @Test
    void getRecipeByIdTest() {
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
        assertEquals(recipe, recipeService.getRecipeById(TestData.TEST_ID));
    }

    @Test
    void getRecipeByIdTestFails() {
        assertThrows(EntityNotFoundException.class, () -> {
            recipeService.getRecipeById(TestData.TEST_ID);
        });
    }

    @Test
    void saveRecipeTest() {
        Recipe savedRecipe = recipeService.saveRecipe(recipe, recipe.getUser());
        assertEquals(recipe.getTitle(), savedRecipe.getTitle());
        assertEquals(recipe.getUser(), savedRecipe.getUser());
        assertEquals(recipe.getRecipeBody(), savedRecipe.getRecipeBody());
    }

    @Test
    void updateRecipeTest() {
        Recipe savedRecipe = recipeService.updateRecipe(recipe, recipe.getUser());
        assertEquals(recipe.getTitle(), savedRecipe.getTitle());
        assertEquals(recipe.getUser(), savedRecipe.getUser());
        assertEquals(recipe.getRecipeBody(), savedRecipe.getRecipeBody());
    }

    @Test
    void deleteRecipeByIdTest() {
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
        when(commentRepository.findByRecipe_Id(anyLong())).thenReturn(new HashSet<>(Collections.singletonList(comment)));

        recipeService.deleteRecipeById(TestData.TEST_ID);
        verify(recipeRepository, atLeastOnce()).delete(any(Recipe.class));
        verify(commentRepository, atLeastOnce()).delete(any(Comment.class));
    }
}
