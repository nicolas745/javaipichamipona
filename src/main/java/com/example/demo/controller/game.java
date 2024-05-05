package com.example.demo.controller;

import com.example.demo.Repository.gameRep;
import com.example.demo.model.Game;
import com.example.demo.struc.gamestruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/game")
public class game {
    private final gameRep gameRep;

    public game(gameRep gameRep) {
        this.gameRep = gameRep;
    }

    @GetMapping("")
    public List<HashMap<String,Object>> game() {
        return new gamestruct(gameRep.findAll()).getData();
    }
}
