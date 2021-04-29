package com.accenture.recipeapp.mapper;

import com.accenture.recipeapp.dto.CommentDto;
import com.accenture.recipeapp.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class MapCommentDtoToEntity {
    public Comment mapCommentToEntity(CommentDto commentDto) {
        var commentEntity = new Comment();
        commentEntity.setId(commentDto.getId());
        commentEntity.setRecipe(commentDto.getRecipe());
        commentEntity.setUser(commentDto.getUser());
        commentEntity.setRecipeComment(commentDto.getRecipeComment());

        return commentEntity;
    }
}
