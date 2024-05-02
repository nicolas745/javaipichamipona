package com.example.demo.struc;

import com.example.demo.model.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class teamstruc {
    private List<team> Listteam = new ArrayList<>();
    public teamstruc(List<team> Listteam){
        this.Listteam = Listteam;
    }
    public List<Map<String, Object>> getdata(){
        List<Map<String,Object >> data = new ArrayList<>();
        for(team t : Listteam){
            data.add(t.getdata());
        }
        return data;
    }
}
