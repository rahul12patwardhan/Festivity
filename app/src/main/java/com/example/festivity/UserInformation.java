package com.example.festivity;

public class UserInformation {

    private String name;
    private String email;
    private String userID;
    private String phone;
    private String college;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public UserInformation(){

    }

    public UserInformation(String name, String email, String userID, String phone, String college) {
        this.name = name;
        this.email = email;
        this.userID = userID;
        this.phone = phone;
        this.college = college;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
