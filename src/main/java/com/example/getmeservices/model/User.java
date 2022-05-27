package com.example.getmeservices.model;

public class User {

    private String id;
    private String name;

    private String email;

    private String profilephotoUrl;


    public User(String id, String name, String email, String profilephotoUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilephotoUrl = profilephotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilephotoUrl() {
        return profilephotoUrl;
    }

    public void setProfilephotoUrl(String profilephotoUrl) {
        this.profilephotoUrl = profilephotoUrl;
    }


}
