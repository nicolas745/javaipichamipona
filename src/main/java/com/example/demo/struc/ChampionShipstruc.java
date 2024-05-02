package com.example.demo.struc;

import com.example.demo.model.ChampionShip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChampionShipstruc {
    private final List<ChampionShip> championShipList;

    public ChampionShipstruc(List<ChampionShip> championShipList) {
        this.championShipList = championShipList;
    }

    public String getData(){
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (ChampionShip championShip : championShipList) {
            list.add(championShip.getData());
        }
        return list.toString();
    }
}
