package com.example.dell.batapp;

/**
 * Created by Dell on 1/12/2015.
 */
public class Criminal {

    protected String name;
    protected String age;
    protected String gender;
    protected String crimes;
    protected String location;
    protected String id;
    //protected String image;

    public Criminal() {

    }

    public Criminal(String name, String age, String gender, String crimes, String location) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crimes = crimes;
        this.location = location;
        //this.image = image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCrimes() {
        return crimes;
    }

    public void setCrimes(String crimes) {
        this.crimes = crimes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //public String getImage() { return image; }

    //public void setImage(String image) { this.image = image; }
}
