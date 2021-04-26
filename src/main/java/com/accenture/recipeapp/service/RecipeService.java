package com.accenture.recipeapp.service;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.repository.CommentRepository;
import com.accenture.recipeapp.repository.RecipeRepository;
import com.accenture.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public Set<Recipe> getAllRecipeByUser(Long id) {
        return recipeRepository.findByUser_Id(id);
    }

    public Recipe saveRecipe(Recipe recipe, User user) {
        try {
            recipe.setUser(user);
            recipeRepository.save(recipe);
            return recipe;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Recipe updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    public Set<Comment> getAllComments(Long id) {
        return commentRepository.findByRecipe_Id(id);
    }
}