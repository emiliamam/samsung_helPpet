package com.example.myapplication.model_animal;

public class animal_lost {

    private String email_user, name_anim, view, metro, street_home;

    public animal_lost(String email_user, String name_anim, String view, String metro, String street_home) {
        this.email_user = email_user;
        this.name_anim = name_anim;
        this.view = view;
        this.metro = metro;
        this.street_home = street_home;
    }

    public animal_lost() {

    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getName_anim() {
        return name_anim;
    }

    public void setName_anim(String name_anim) {
        this.name_anim = name_anim;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getStreet_home() {
        return street_home;
    }

    public void setStreet_home(String street_home) {
        this.street_home = street_home;
    }
}
