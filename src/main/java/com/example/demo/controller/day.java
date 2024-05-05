package com.example.demo.controller;

import com.example.demo.Repository.dayRep;
import com.example.demo.struc.daystruc;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/day")
public class day {
    private final dayRep dayRep;
    public day(dayRep dayRep) {
        this.dayRep = dayRep;
    }

    @GetMapping("/")
    public List<HashMap<String,Object>> day(){
        return new daystruc(dayRep.findAll()).getData();
    }
    @PutMapping("/id/{id}")
    public HashMap<String,Object> update(@PathVariable long id, @RequestBody com.example.demo.model.day day){
        if(dayRep.findById(id).isPresent()){
            if(day.getNumber()==null){
                dayRep.findById(id).get().setNumber(day.getNumber());
            }
            if(day.getNumber()!=null){
                dayRep.findById(id).get().setNumber(day.getNumber());
            }
            dayRep.save(dayRep.findById(id).get());
        }
        return dayRep.findById(id).get().getData();
    }
    @DeleteMapping("/id/{id}")
    public boolean delete(@PathVariable long id){
        if(dayRep.findById(id).isPresent()){
            dayRep.deleteById(id);
            return true;
        }
        return false;
    }
}
