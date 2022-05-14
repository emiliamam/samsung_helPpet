package com.example.myapplication.Model;

public class model {
    public String titel, image;

    public model(String titel, String image) {
        this.titel = titel;
        this.image = image;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
