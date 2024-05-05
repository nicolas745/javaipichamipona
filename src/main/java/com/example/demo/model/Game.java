package com.example.demo.model;

import jakarta.persistence.*;
import com.example.demo.Repository.teamRep;

import java.util.HashMap;

@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "Team1Point")
    private int team1Point;

    @Column(name = "Team2Point")
    private int team2Point;

    @ManyToOne()
    @JoinColumn(name = "idTeam1")
    private team Team1;

    @ManyToOne()
    @JoinColumn(name = "idTeam2")
    private team Team2;

    @ManyToOne
    @JoinColumn(name = "idDay")
    private day day;

    public Game() {

    }
    public Game(int team1Point, int team2Point,team Team1, team Team2, day day) {
        this.team1Point = team1Point;
        this.team2Point = team2Point;
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.day = day;
    }

    public HashMap<String,Object> getData(){
        HashMap<String,Object> data = new HashMap<>();
        data.put("id",id);
        data.put("Team1Point",team1Point);
        data.put("Team2Point",team2Point);
        data.put("Team1",Team1);
        data.put("Team2",Team2);
        data.put("Day",day);
        return data;
    }
}
