package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;

    @ElementCollection // M:M mapping
    @Enumerated(EnumType.STRING) // table for emun
    private List<Feature> auditoriumFeatures;


}

// Auditorium : Features -> M:M
// Auditorium : Theatre -> M:1
// Auditorium : Seats -> 1:M