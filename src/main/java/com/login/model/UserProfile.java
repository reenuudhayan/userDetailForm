package com.login.model;

import lombok.Data;

@Data
public class UserProfile {
    private String accessToken;
    private String refreshToken;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String address;
    private String state;
    private String country;
    private String pinCode;
    private String height;
    private String weight;
}
