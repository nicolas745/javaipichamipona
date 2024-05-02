package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ChampionShip")
public class ChampionShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @ManyToMany
    @JoinTable(
            name = "Team_Championship",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<team> teams;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "wonPoint")
    private int wonPoint;

    @Column(name = "lostPoint")
    private int lostPoint;

    @Column(name = "drawPoint")
    private int drawPoint;
    public ChampionShip() {

    }
    public ChampionShip(String name,Set<team> teams, Date startDate, Date endDate, int wonPoint, int lostPoint, int drawPoint) {
        this.name = name;
        this.teams = teams;
        this.startDate = startDate;
        this.endDate = endDate;
        this.wonPoint = wonPoint;
        this.lostPoint = lostPoint;
        this.drawPoint = drawPoint;
    }
    public HashMap<String,Object> getData() {
        HashMap<String,Object> data = new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("teams",teams);
        data.put("startDate",startDate);
        data.put("endDate",endDate);
        data.put("wonPoint",wonPoint);
        return data;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getWonPoint() {
        return wonPoint;
    }
    public void setWonPoint(int wonPoint) {
        this.wonPoint = wonPoint;
    }
    public int getLostPoint() {
        return lostPoint;
    }
    public void setLostPoint(int lostPoint) {
        this.lostPoint = lostPoint;
    }
    public int getDrawPoint() {
        return drawPoint;
    }
    public void setDrawPoint(int drawPoint) {
        this.drawPoint = drawPoint;
    }

}
