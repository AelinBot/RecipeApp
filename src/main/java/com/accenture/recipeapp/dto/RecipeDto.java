package com.accenture.recipeapp.dto;

import com.accenture.recipeapp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeDto {
    private Long id;
    private String title;
    private User user;
    private String recipeBody;
}
