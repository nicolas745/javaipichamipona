package com.example.demo.controller;

import com.example.demo.Repository.ChampionShipRep;
import com.example.demo.struc.ChampionShipstruc;
import jakarta.validation.constraints.Null;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/championnats")
public class ChampionShip {
    private final ChampionShipRep championShipRep;
    public ChampionShip(ChampionShipRep championShipRep) {
        this.championShipRep = championShipRep;
    }
    @GetMapping(value = "/")
    public List<HashMap<String,Object>> list() {
        return new ChampionShipstruc(championShipRep.findAll()).getData();
    }

    @GetMapping(value = "/id/{idChampionShip}")
    public HashMap<String,Object> idChampionShip(@PathVariable Long idChampionShip) {
        if (championShipRep.findById(idChampionShip).isPresent()) {
            return championShipRep.findById(idChampionShip).get().getData();
        }
        return new HashMap<>();
    }
    @PostMapping(value = "/")
    public HashMap<String,Object> add(@RequestBody com.example.demo.model.ChampionShip championShip) {
        championShipRep.save(championShip);
        return  championShip.getData();
    }

    @PutMapping(value = "/id/{idChampionShip}")
    public HashMap<String,Object> putChampion(@PathVariable Long idChampionShip,@RequestBody com.example.demo.model.ChampionShip championShip){
        if(championShipRep.findById(idChampionShip).isPresent()){
            if (championShip.getName() != null) {
                championShipRep.findById(idChampionShip).get().setName(championShip.getName());
            }
            if (championShip.getStartDate() != null) {
                championShipRep.findById(idChampionShip).get().setStartDate(championShip.getStartDate());
            }
            if (championShip.getEndDate() != null) {
                championShipRep.findById(idChampionShip).get().setEndDate(championShip.getEndDate());
            }
            if (championShip.getWonPoint() >= 0) {
                championShipRep.findById(idChampionShip).get().setWonPoint(championShip.getWonPoint());
            }
            if (championShip.getLostPoint() >= 0) {
                championShipRep.findById(idChampionShip).get().setLostPoint(championShip.getLostPoint());
            }
            if (championShip.getDrawPoint() >= 0) {
                championShipRep.findById(idChampionShip).get().setDrawPoint(championShip.getDrawPoint());
            }
            championShipRep.save(championShipRep.findById(idChampionShip).get());
        }
        return  championShipRep.findById(idChampionShip).get().getData();
    }

    @DeleteMapping(value = "/id/{idChampionShip}")
    public boolean delete(@PathVariable Long idChampionShip) {
        if (championShipRep.findById(idChampionShip).isPresent()) {
            championShipRep.deleteById(idChampionShip);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
