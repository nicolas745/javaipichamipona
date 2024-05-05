package com.example.demo.model;

import jakarta.persistence.*;

import java.util.HashMap;

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

    public HashMap<String,Object> getData(){
        HashMap<String,Object> data = new HashMap<>();
        data.put("id",getId());
        data.put("number",getNumber());
        data.put("ChampionShip",getChampionShip());
        return data;
    }

    public long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public ChampionShip getChampionShip() {
        return ChampionShip;
    }
    public void setChampionShip(ChampionShip ChampionShip) {
        this.ChampionShip = ChampionShip;
    }
}
