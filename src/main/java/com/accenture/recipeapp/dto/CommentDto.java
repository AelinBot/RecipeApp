package com.accenture.recipeapp.dto;

import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;

public class CommentDto {
    private Long id;
    private Recipe recipe;
    private User user;
    private String recipeComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipeComment() {
        return recipeComment;
    }

    public void setRecipeComment(String recipeComment) {
        this.recipeComment = recipeComment;
    }
}
