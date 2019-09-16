package com.stl.birthdayreminder;

public class User
{
    public String name;
    public String email;
    public String contact;
    public String bDate;
    public String profile;
    /*public User(String name,String email,String contact,String bDate)
    {
        this.bDate = bDate;
        this.contact = contact;
        this.email = email;
        this.name = name;
    }*/
    public User(String name,String bDate,String profile,String contact,String email)
    {
        this.bDate = bDate;
        this.name=name;
        this.profile=profile;
        this.email=email;
        this.contact=contact;
    }


}
