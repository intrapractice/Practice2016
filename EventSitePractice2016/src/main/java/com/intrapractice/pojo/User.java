package com.intrapractice.pojo;

import java.util.List;

public class User {
    
    private int id;
    
    private String email;
    
    private String name;
    
    private String token;
    
    private List<Integer> likedEvents;

    public User(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getLikedEvents() {
        return likedEvents;
    }

    public void setLikedEvents(List<Integer> likedEvents) {
        this.likedEvents = likedEvents;
    }

}
