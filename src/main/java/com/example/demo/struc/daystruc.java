package com.example.demo.struc;

import com.example.demo.model.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class daystruc {
    private final List<day> days;

    public daystruc(List<day> days) {
        this.days = days;
    }

    public List<HashMap<String, Object>> getData(){
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (day day : days) {
            list.add(day.getData());
        }
        return list;
    }
}
