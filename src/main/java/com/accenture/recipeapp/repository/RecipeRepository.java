package com.accenture.recipeapp.repository;

import com.accenture.recipeapp.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Set<Recipe> findByUserId(Long userId);
}