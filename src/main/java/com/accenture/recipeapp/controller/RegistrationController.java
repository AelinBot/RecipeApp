package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.dto.UserDto;
import com.accenture.recipeapp.mapper.MapUserDtoToEntity;
import com.accenture.recipeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapUserDtoToEntity mapUserDtoToEntity;

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping
    public String addUser(@ModelAttribute UserDto userDto) {
        if (userService.userExists(mapUserDtoToEntity.mapUserToEntity(userDto).getUsername())) {
            return "redirect:/login";
        }
        userService.saveUserRegister(mapUserDtoToEntity.mapUserToEntity(userDto));
        return "redirect:/login";
    }
}
