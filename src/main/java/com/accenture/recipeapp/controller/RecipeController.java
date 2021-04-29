package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.dto.CommentDto;
import com.accenture.recipeapp.dto.RecipeDto;
import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.mapper.MapCommentDtoToEntity;
import com.accenture.recipeapp.mapper.MapRecipeDtoToEntity;
import com.accenture.recipeapp.service.CommentService;
import com.accenture.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MapCommentDtoToEntity mapCommentDtoToEntity;

    @Autowired
    private MapRecipeDtoToEntity mapRecipeDtoToEntity;

    String recipeString = "recipe";
    String recipeRedirect = "redirect:/recipe/";

    @GetMapping("/all")
    public String getAllRecipes(Model model, @AuthenticationPrincipal User user) {
        List<Recipe> recipeList = recipeService.getAllRecipes();
        model.addAttribute("user", user);
        model.addAttribute("recipes", recipeList);
        return "recipes";
    }

    @GetMapping("/{recipeId}")
    public String recipePage(@PathVariable("recipeId") Long recipeId, Model model, @AuthenticationPrincipal User user) {

        var recipe = recipeService.getRecipeById(recipeId);
        Set<Comment> recipeComments = recipeService.getAllComments(recipeId);

        model.addAttribute(recipeString, recipe);
        model.addAttribute("recipeComments", recipeComments);
        model.addAttribute("user", user);
        return recipeString;
    }

    @GetMapping("/new")
    public String createRecipe(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "new-recipe";
    }

    @PostMapping()
    public String postRecipe(@ModelAttribute RecipeDto recipeDto, @AuthenticationPrincipal User user) {
        recipeService.saveRecipe(mapRecipeDtoToEntity.mapRecipeToEntity(recipeDto), user);
        return "redirect:/recipe/all";
    }

    @GetMapping("/update/{recipeId}")
    public String editRecipe(Model model, @PathVariable("recipeId") Long recipeId, @AuthenticationPrincipal User user) {
        var recipe = recipeService.getRecipeById(recipeId);
        model.addAttribute(recipeString, recipe);
        model.addAttribute("user", user);
        return "edit-recipe";
    }

    @PostMapping("/update/{recipeId}")
    public String updateRecipe(@PathVariable("recipeId") Long recipeId, @ModelAttribute RecipeDto recipeDto, @AuthenticationPrincipal User user) {
        recipeDto.setId(recipeId);
        recipeValidation(recipeId, user.getId());

        recipeService.saveRecipe(mapRecipeDtoToEntity.mapRecipeToEntity(recipeDto), user);

        return recipeRedirect + recipeId;
    }

    @GetMapping("/delete/{recipeId}")
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId, @AuthenticationPrincipal User user) {
        recipeValidation(recipeId, user.getId());
        recipeService.deleteRecipeById(recipeId);
        return "redirect:/recipe/all";
    }

    @PostMapping("/{recipeId}/comment")
    public String addComment(@PathVariable("recipeId") Long recipeId, @ModelAttribute CommentDto commentDto, @AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }
        commentDto.setRecipe(recipeService.getRecipeById(recipeId));
        commentDto.setUser(user);
        commentService.saveComment(mapCommentDtoToEntity.mapCommentToEntity(commentDto));
        return recipeRedirect + recipeId;
    }

    @GetMapping("/{recipeId}/comment/delete/{commentId}")
    public String deleteComment(@PathVariable("recipeId") Long recipeId, @PathVariable("commentId") Long commentId, @AuthenticationPrincipal User user) {
        var commentValidation = commentService.getCommentById(commentId);
        if (!(user.getId()).equals(commentValidation.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        commentService.deleteComment(commentId);
        return recipeRedirect + recipeId;
    }

    private void recipeValidation(Long recipeId, Long userId) {
        var recipeTest = recipeService.getRecipeById(recipeId);
        if (!recipeTest.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}