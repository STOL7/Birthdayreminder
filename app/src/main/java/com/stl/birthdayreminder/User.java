package com.stl.birthdayreminder;

public class User
{
    public String name;
    public String email;
    public String contact;
    public String bDate;

    public User()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String profile;
    public User(String name,String profile,String bDate)
    {
        this.bDate = bDate;

        this.profile = profile;
        this.name = name;
    }
    public User(String name,String bDate,String profile,String contact,String email)
    {
        this.bDate = bDate;
        this.name=name;
        this.profile=profile;
        this.email=email;
        this.contact=contact;
    }


}
