package com.accenture.recipeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipe_comment")
public class Comment implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeComment;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Comment)) return false;
        Comment that = (Comment) o;
        return Objects.equals(recipe.getId(), that.recipe.getId()) &&
                Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(recipeComment, that.recipeComment);
    }

    @Override
    public int hashCode() {
        return(Objects.hash(recipe.getId(), user.getId(), recipeComment));
    }
}