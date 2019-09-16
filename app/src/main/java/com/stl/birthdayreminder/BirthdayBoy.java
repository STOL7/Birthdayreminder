package com.stl.birthdayreminder;

public class BirthdayBoy
{
    public String name;
    public String profile;
    public String bDate;

    public BirthdayBoy(String name, String profile, String bDate)
    {
        this.name = name;
        this.profile = profile;
        this.bDate = bDate;
    }

    public BirthdayBoy() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public String getbDate() {
        return bDate;
    }
}
