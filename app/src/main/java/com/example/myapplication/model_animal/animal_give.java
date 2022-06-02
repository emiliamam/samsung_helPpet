package com.example.myapplication.model_animal;

public class animal_give {

    private String email_user, upload_uri, name_anim, view, description, metro, street_home;


    public animal_give(String email, String upload_uri, String category, String name, String description, String street, String metro) {
        this.email_user = email;
        this.upload_uri = upload_uri;
        this.view = category;
        this.name_anim = name;
        this.description = description;
        this.street_home = street;
        this.metro = metro;
    }
    public animal_give(){}

    public String getUpload_uri() {
        return upload_uri;
    }

    public void setUpload_uri(String upload_uri) {
        this.upload_uri = upload_uri;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
