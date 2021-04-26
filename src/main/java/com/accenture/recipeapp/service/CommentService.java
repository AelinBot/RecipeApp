package com.accenture.recipeapp.service;

import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveCommentRegister(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    public String deleteCommentRegister(Long id) {
        Comment commentToDelete = commentRepository.getOne(id);
        commentRepository.delete(commentToDelete);
        return "Comment deleted";
    }
}