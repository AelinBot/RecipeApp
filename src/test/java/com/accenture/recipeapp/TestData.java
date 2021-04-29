package com.accenture.recipeapp;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.Role;
import com.accenture.recipeapp.entity.User;

import java.util.HashSet;
import java.util.Set;

public class TestData {
    public static final long TEST_ID = 1L;
    public static final long TEST_ID_2 = 2L;
    public static final String TEST_USERNAME = "TestUsername";
    public static final String TEST_PASSWORD = "TestPassword";
    public static final String TEST_TITLE = "Title";
    public static final String TEST_RECIPE_BODY = "Recipe body";
    public static final String TEST_COMMENT = "Comment";
    public static final String TEST_COMMENT_2 = "Comment 2";

    public static User getUser() {
        User user = new User();
        user.setId(TEST_ID);
        user.setUsername(TEST_USERNAME);
        user.setPassword(TEST_PASSWORD);
        user.setRoles(getRoles());

        return user;
    }

    public static Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();

        Recipe recipe1 = new Recipe();
        recipe1.setId(TEST_ID);
        recipe1.setTitle(TEST_TITLE);
        recipe1.setRecipeBody(TEST_RECIPE_BODY);
        recipe1.setUser(getUser());

        Recipe recipe2 = new Recipe();
        recipe2.setId(TEST_ID_2);
        recipe2.setTitle(TEST_TITLE);
        recipe2.setRecipeBody(TEST_RECIPE_BODY);
        recipe2.setUser(getUser());

        recipes.add(recipe1);
        recipes.add(recipe2);

        return recipes;
    }

    public static Recipe getRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(TEST_ID);
        recipe.setTitle(TEST_TITLE);
        recipe.setRecipeBody(TEST_RECIPE_BODY);
        recipe.setUser(getUser());

        return recipe;
    }

    public static Set<Comment> getComments() {
        Set<Comment> comments = new HashSet<>();

        Comment comment1 = new Comment();
        comment1.setId(TEST_ID);
        comment1.setUser(getUser());
        comment1.setRecipe(getRecipe());
        comment1.setRecipeComment(TEST_COMMENT);

        Comment comment2 = new Comment();
        comment2.setId(TEST_ID_2);
        comment2.setUser(getUser());
        comment2.setRecipe(getRecipe());
        comment2.setRecipeComment(TEST_COMMENT_2);

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    public static Comment getComment() {
        Comment comment = new Comment();
        comment.setId(TEST_ID);
        comment.setUser(getUser());
        comment.setRecipe(getRecipe());
        comment.setRecipeComment(TEST_COMMENT);

        return comment;
    }

    public static Set<Role> getRoles() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.USER);

        return roleSet;
    }
}
