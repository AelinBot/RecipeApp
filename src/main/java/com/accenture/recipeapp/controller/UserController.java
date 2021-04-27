package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.service.RecipeService;
import com.accenture.recipeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("recipes", recipeService.getAllRecipeByUser(user.getId()));
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/{username}")
    public String findUserProfile(Model model, @PathVariable("username") String username, @AuthenticationPrincipal User user) {
        if (user != null && username.equals(user.getUsername())) {
            return "redirect:/user/profile";
        }
        User u = userService.getUserByUsername(username);
        model.addAttribute("user", u);
        model.addAttribute("recipes", recipeService.getAllRecipeByUser(u.getId()));
        return "user-page";
    }

    @PostMapping("/update/password")
    public String changeUserPassword(@AuthenticationPrincipal User user, @RequestParam String password) {
        userService.updateUserPassword(user, password);
        return "redirect:/user/profile";
    }
}