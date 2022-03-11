package com.teksystems;

public class ClubMember {
    String name;
    String location;
    String language;

    public ClubMember(String name, String location, String language){
        this.name = name;
        this.location = location;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
