package com.example.toysapplication;

import java.io.Serializable;

public class UserData implements Serializable {
    private String name;

    private String mobileNumber;

    public UserData(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }




    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



}

