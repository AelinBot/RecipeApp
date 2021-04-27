package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("recipes", recipeService.getAllRecipeByUser(user.getId()));
        model.addAttribute("user", user);
        return "profile";
    }
}
