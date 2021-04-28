package com.accenture.recipeapp.repository;

import com.accenture.recipeapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Set<Comment> findByRecipe_Id(Long userId);
}