package com.example.myapplication.model_animal;

public class animal_find {

    private String email_user,upload_uri, view, metro, street_home;

    public animal_find(String email_user, String upload_uri, String view, String metro, String street_home) {
        this.email_user = email_user;
        this.upload_uri = upload_uri;
        this.view = view;
        this.metro = metro;
        this.street_home = street_home;
    }
    public String getUpload_uri() {
        return upload_uri;
    }

    public void setUpload_uri(String upload_uri) {
        this.upload_uri = upload_uri;
    }

    public animal_find() {

    }



    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
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
