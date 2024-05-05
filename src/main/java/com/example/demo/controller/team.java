package com.example.demo.controller;

import com.example.demo.Repository.ChampionShipRep;
import com.example.demo.Repository.teamRep;
import com.example.demo.model.ChampionShip;
import com.example.demo.struc.teamstruc;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(name = "/api/team")
public class team {
    private final com.example.demo.Repository.teamRep teamRep;
    private final ChampionShipRep championShipRep;

    public team(teamRep teamRep, ChampionShipRep championShipRep) {
        this.teamRep = teamRep;
        this.championShipRep = championShipRep;
    }

    @GetMapping("/")
    public List<Map<String, Object>> list(@RequestParam("championshipId") Optional<Integer> championshipId) {
        if (championshipId.isPresent()) {
            return new teamstruc(teamRep.findTeamsByChampionships_Id(championshipId.get().longValue())).getdata();
        } else {
            return new teamstruc(teamRep.findAll()).getdata();
        }
    }
    @GetMapping("/id/{id}")
    public Map<String, Object> teamById(@PathVariable Long id) {
        if (teamRep.findById(id).isPresent()) {
            return teamRep.findById(id).get().getdata();
        }
        return null;
    }

    @PostMapping(value = "/id/{id}/addchampionshipId")
    public boolean addChampionshipId(@PathVariable Long id, @RequestBody Long addchampionshipId) {
        Optional<com.example.demo.model.team> team = teamRep.findById(id);
        Optional<ChampionShip> championShip = championShipRep.findById(addchampionshipId);
        if (team.isPresent() && championShip.isPresent()) {
            com.example.demo.model.team Team = team.get();
            ChampionShip ChampionShip = championShip.get();
            Team.getChampionships().add(ChampionShip);
            teamRep.save(Team);
            return true;
        }else {
            return false;
        }
    }
    @DeleteMapping("/id/{id}")
    public boolean deleteChampionshipId(@PathVariable Long id) {
        Optional<com.example.demo.model.team> team = teamRep.findById(id);
        if (team.isPresent()) {
            teamRep.delete(team.get());
            return true;
        }
        return false;
    }
}


