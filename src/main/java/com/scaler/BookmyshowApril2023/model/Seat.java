package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
   private String seatNumber;

   @Enumerated(EnumType.STRING) // create a table for enum and mark the entity
   private SeatType seatType;

   @Enumerated(EnumType.STRING)
   private SeatStatus seatStatus;

   @ManyToOne
   private Auditorium auditorium;
}

/*
    Seat : SeatType -> M : 1
    Seat : SeatStatus -> M : 1
    Seat : Auditorium -> M : 1
 */