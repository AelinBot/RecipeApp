package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.service.CommentService;
import com.accenture.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String getAllRecipes() {
        return "recipes";
    }

    @GetMapping("/{recipeId}")
    public String recipePage(@PathVariable("recipeId") Long recipeId, Model model, @AuthenticationPrincipal User user) {

        Recipe recipe = recipeService.getRecipeById(recipeId);
        Set<Comment> recipeComments = recipeService.getAllComments(recipeId);

        model.addAttribute("recipe", recipe);
        model.addAttribute("recipeComments", recipeComments);
        model.addAttribute("user", user);
        return "recipe";
    }

    @GetMapping("/new")
    public String createRecipe(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "new-recipe";
    }
}