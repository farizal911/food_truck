package com.example.restaurantapplications;

public class RestaurantModel {
    String name;
    String address;
    int imageResId;
    String phoneNumber;
    String workingTime;
    String closingDay;

    public RestaurantModel(String name, String address, int imageResId, String phoneNumber, String workingTime, String closingDay) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
        this.phoneNumber = phoneNumber;
        this.workingTime = workingTime;
        this.closingDay = closingDay;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getClosingDay() {
        return closingDay;
    }
}