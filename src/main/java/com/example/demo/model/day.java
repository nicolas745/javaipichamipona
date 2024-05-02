package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Day")
public class day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "idChampionShip")
    private ChampionShip ChampionShip;

    public day(){

    }
    public day(String number, ChampionShip ChampionShip) {
        this.number = number;
        this.ChampionShip = ChampionShip;
    }
}
