package com.example.cropapp;

public class Crop {
    private String Cropname=null;
    private String Qunatity=null;
    public Crop() {
    }

    public Crop(String cropname, String qunatity) {
        Cropname = cropname;
        Qunatity = qunatity;
    }

    public String getCropname() {
        return Cropname;
    }

    public String getQunatity() {
        return Qunatity;
    }
}
