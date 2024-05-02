package com.example.demo.struc;

import com.example.demo.model.user;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userstruc {
    private List<user> Listuser = new ArrayList<>();
    public userstruc(List<user> Listuser){
        this.Listuser = Listuser;
    }
    public List<Map<String, Object>> getdata(){
        List<Map<String,Object >> data = new ArrayList<>();
        for(user u : Listuser){
            data.add(u.getdata());
        }
        return data;
    }
}
