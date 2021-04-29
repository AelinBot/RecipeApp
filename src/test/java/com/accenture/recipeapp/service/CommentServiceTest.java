package com.accenture.recipeapp.service;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.entity.Comment;
import com.accenture.recipeapp.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CommentServiceTest {

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    CommentService commentService;

    Comment comment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        comment = TestData.getComment();
    }

    @Test
    void saveCommentTest() {
        Comment savedComment = commentService.saveComment(comment);
        assertEquals(comment.getRecipe(), savedComment.getRecipe());
        assertEquals(comment.getUser(), savedComment.getUser());
    }

    @Test
    void deleteCommentTest() {
        commentService.deleteComment(TestData.TEST_ID);
        verify(commentRepository, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void getCommentByIdTest() {
        when(commentRepository.findById(anyLong())).thenReturn(Optional.of(comment));
        assertEquals(comment, commentService.getCommentById(TestData.TEST_ID));
    }
}
