package com.accenture.recipeapp.service;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.repository.CommentRepository;
import com.accenture.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public Set<Recipe> getAllRecipeByUser(Long id) {
        return recipeRepository.findByUser_Id(id);
    }

    public List<Recipe> getAllRecipes() { return recipeRepository.findAll(); }

    public Recipe saveRecipe(Recipe recipe, User user) {
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe updateRecipe(Recipe recipe, User user) {
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return recipe;
    }

    public void deleteRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Set<Comment> recipeComments = commentRepository.findByRecipe_Id(recipe.getId());
        recipeComments.forEach(recipeComment -> commentRepository.delete(recipeComment));
        recipeRepository.delete(recipe);
    }

    public Set<Comment> getAllComments(Long id) {
        return commentRepository.findByRecipe_Id(id);
    }
}