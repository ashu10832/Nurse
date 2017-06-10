package com.example.ashugupta.nurse;

/**
 * Created by ashugupta on 11/03/17.
 */
public class Document {
    private String Name;
    private String Description;
    private String Mobile;
    private String Speciality;
    private String Address;
    private String rating;
    private int image;

    public Document(String name, String speciality, String rating,int image,String description) {
        Name = name;
        Speciality = speciality;
        this.rating = rating;
        this.image = image;
        this.Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public int getImage() {
        return image;
    }
}