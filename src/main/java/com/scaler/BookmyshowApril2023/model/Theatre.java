package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> auditoriums;

    @ManyToOne
    private City city;
}

/*
    Theatre : Auditorium -> 1 : M
    Theatre : City -> M : 1
 */
