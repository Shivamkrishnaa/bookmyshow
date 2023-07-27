package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String description;
    private int length;
    private double rating;
    @OneToMany
    private List<Show> shows;
    @ManyToMany
    private List<Actor> actors;

    @ElementCollection // M:M mapping
    @Enumerated(EnumType.STRING) // table for enum
    private List<Feature> auditoriumFeatures;

    @ElementCollection // M:M mapping
    @Enumerated(EnumType.STRING) // table for enum
    private List<Language> languages;

}

/*

        Movie : Show -> 1:M
        Movie : Actors -> M : M
        Movie : Language -> M : M

 */
