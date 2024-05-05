package com.example.demo.controller;
import com.example.demo.struc.userstruc;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Repository.userRep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user")
public class user {
    private final userRep userRep;
    public user( userRep userRep){
        this.userRep = userRep;
    }

    @GetMapping("/")
    public List<Map<String, Object>> list(){
        return new userstruc(userRep.findAll()).getdata();
    }
    @GetMapping("/id/{userId}")
    public Map<String, Object> getById(@PathVariable Long userId){
        Optional<com.example.demo.model.user> user = userRep.findById(userId);
        if(user.isPresent()){
            return user.get().getdata();
        } else {
            return new HashMap<>();
        }
    }
    @GetMapping("/user")
    public Map<String, Object> selectuser(HttpServletRequest request ){
        Optional<com.example.demo.model.user> user = userRep.findByEmail(request.getParameter("email"));
        if(user.isPresent()){
            if(verifyPasswords(user.get().getPassword(),request.getParameter("password"))){
                return user.get().getdata();
            }else{
                return null;
            }
        } else {
            return null;
        }
    }
    public boolean verifyPasswords(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody com.example.demo.model.user user){
        user.setPassword(user.getPassword());
        userRep.save(user);
        return user.getdata();
    }

    @PutMapping("/id/{iduser}")
    public Map<String, Object> updateuser(@PathVariable Long iduser, @RequestBody com.example.demo.model.user user){
        if(userRep.findById(iduser).isPresent()){
            if(user.getPassword()!=null){
                userRep.findById(iduser).get().setPassword(user.getPassword());
            }
            if(user.getEmail()!=null){
                userRep.findById(iduser).get().setEmail(user.getEmail());
            }
            if(user.getFistName()!=null){
                userRep.findById(iduser).get().setFistName(user.getFistName());
            }
            if(user.getLastName()!=null){
                userRep.findById(iduser).get().setLastName(user.getLastName());
            }
            userRep.save(userRep.findById(iduser).get());
        }
        return userRep.findById(iduser).get().getdata();
    }
    @DeleteMapping("/id/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        Optional<com.example.demo.model.user> optionalUser = userRep.findById(id);
        if (optionalUser.isPresent()) {
            userRep.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
