package com.aryan.lbrybrowser.model;

import lombok.Data;

@Data
public class Location {
    private double latitude;
    private double longitude;
    private String country;
    private String state;
    private String city;
    private String code;
}
