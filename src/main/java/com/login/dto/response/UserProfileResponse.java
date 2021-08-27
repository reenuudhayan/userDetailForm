package com.login.dto.response;

import lombok.Data;

public class UserProfileResponse {
    @Data
    public class UserProfileResponse {

        private String userId;
        private String firstName;
        private String lastName;
        private String email; //userName
        private String mobileNumber;
        private String state;
        private String country;
        private String address;
        private String pinCode;
        private String weight;
        private String height;


    }
}