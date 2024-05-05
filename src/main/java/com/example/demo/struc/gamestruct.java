package com.example.demo.struc;

import com.example.demo.model.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gamestruct {
    private List<Game> games;

    public gamestruct(List<Game> games) {
        this.games = games;
    }

    public List<HashMap<String, Object>> getData(){
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (Game game : games) {
            list.add(game.getData());
        }
        return list;
    }
}
