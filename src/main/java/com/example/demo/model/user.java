package com.example.demo.model;

import com.example.demo.hash.md5;
import jakarta.persistence.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "User")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fistName")
    private String fistName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "CreateDate")
    private Date createDate;
    public user(){

    }
    public user(String fistName, String lastName, String email, String password ){
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createDate = new Date();
    }

    public String getFistName() {
        return fistName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public long getId() {
        return id;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = new md5().passwd(password);
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Map<String, Object> getdata(){
        Map<String,Object> data = new HashMap<>();
        data.put("fistName",fistName);
        data.put("lastName",lastName);
        data.put("email",email);
        data.put("password",password);
        data.put("createDate",createDate);
        data.put("id",id);
        return data;
    }

}
