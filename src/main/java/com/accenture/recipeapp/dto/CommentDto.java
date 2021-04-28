package com.accenture.recipeapp.dto;

import com.accenture.recipeapp.entity.Recipe;
import com.accenture.recipeapp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Recipe recipe;
    private User user;
    private String recipeComment;
}
