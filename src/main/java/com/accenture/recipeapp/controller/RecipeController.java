package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.service.CommentService;
import com.accenture.recipeapp.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
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

    @PostMapping()
    public String postRecipe(@ModelAttribute Recipe recipe, @AuthenticationPrincipal User user) throws IOException {
        recipeService.saveRecipe(recipe, user);
        return "redirect:/recipe/";
    }

    @GetMapping("/update/{recipeId}")
    public String editRecipe(Model model, @PathVariable("recipeId") Long recipeId, @AuthenticationPrincipal User user) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("user", user);
        return "edit-recipe";
    }

    @PostMapping("/update/{recipeId}")
    public String updateRecipe(@PathVariable("recipeId") Long recipeId, @ModelAttribute Recipe recipe, @AuthenticationPrincipal User user, @RequestParam("button") String command) throws IOException {
        recipe.setId(recipeId);
        recipeValidation(recipeId, user.getId());

        if (command.equals("update")) {
            recipeService.updateRecipe(recipe, user);
        }

        return "redirect:/recipe/" + recipeId;
    }

    @GetMapping("/delete/{recipeId}")
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId, @AuthenticationPrincipal User user) {
        recipeValidation(recipeId, user.getId());
        recipeService.deleteRecipeById(recipeId);
        return "redirect:/recipe/";
    }

    @PostMapping("/{recipeId}/comment")
    public String addComment(@PathVariable("recipeId") Long recipeId, @ModelAttribute Comment comment, @AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }
        comment.setRecipe(recipeService.getRecipeById(recipeId));
        comment.setUser(user);
        commentService.saveComment(comment);
        return "redirect:/recipe/" + recipeId;
    }

    @GetMapping("/{recipeId}/comment/delete/{commentId}")
    public String deleteComment(@PathVariable("recipeId") Long recipeId, @PathVariable("commentId") Long commentId, @AuthenticationPrincipal User user) {
        Comment commentValidation = commentService.getCommentById(commentId);
        if (!(user.getId()).equals(commentValidation.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        commentService.deleteComment(commentId);
        return "redirect:/recipe/" + recipeId;
    }

    private void recipeValidation(Long recipeId, Long userId) {
        Recipe recipeTest = recipeService.getRecipeById(recipeId);
        if (!recipeTest.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}