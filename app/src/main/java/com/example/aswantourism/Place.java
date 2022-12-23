package com.example.aswantourism;


import java.net.URI;

public class Place {
    private String name;
    private int image;
    private int brief;
    private String location;

    public Place(String name, int image, int brief, String location){
        this.name=name;
        this.image=image;
        this.brief=brief;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImage() {
        return image;
    }

    public int getBrief() {
        return brief;
    }
}
