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
public class ShowSeat extends BaseModel{
    private int price;

    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus seatStatus;
}

/*
    ShowSeat : Seat -> M : 1
    ShowSeat : Show -> M : 1
    ShowSeat : Ticket -> M : 1
 */