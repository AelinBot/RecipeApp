package com.accenture.recipeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
}