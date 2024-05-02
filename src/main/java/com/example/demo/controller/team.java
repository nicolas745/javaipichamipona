package com.example.demo.controller;

import com.example.demo.Repository.teamRep;
import com.example.demo.struc.teamstruc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(name = "/api/team")
public class team {
    private final com.example.demo.Repository.teamRep teamRep;

    public team(teamRep teamRep) {
        this.teamRep = teamRep;
    }

    @GetMapping
    public List<Map<String, Object>> team() {
        return  new teamstruc(teamRep.findAll()).getdata();
    }
}


