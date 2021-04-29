package com.accenture.recipeapp.mapper;

import com.accenture.recipeapp.dto.RecipeDto;
import com.accenture.recipeapp.entity.Recipe;
import org.springframework.stereotype.Component;

@Component
public class MapRecipeDtoToEntity {
    public Recipe mapRecipeToEntity(RecipeDto recipeDto) {
        var recipeEntity = new Recipe();
        recipeEntity.setId(recipeDto.getId());
        recipeEntity.setUser(recipeDto.getUser());
        recipeEntity.setTitle(recipeDto.getTitle());
        recipeEntity.setRecipeBody(recipeDto.getRecipeBody());

        return recipeEntity;
    }
}
