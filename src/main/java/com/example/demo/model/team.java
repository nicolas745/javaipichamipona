package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name = "team")
public class team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "name")
    private String name;

    @Column(name = "CreationDate")
    private Date creationDate;
    @ManyToMany
    @JoinTable(
            name = "Team_Championship",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "championship_id")
    )
    private Set<ChampionShip> championships;

    public team(){

    }
    public team(String name,Set<ChampionShip> championships){
        this.name = name;
        this.championships = championships;
        this.creationDate = new Date();
    }
    public HashMap<String,Object> getdata(){
        HashMap<String,Object> data = new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("creationDate",creationDate);
        data.put("championships",championships);
        return data;
    }
    public Set<ChampionShip> getChampionships(){
        return championships;
    }
}
