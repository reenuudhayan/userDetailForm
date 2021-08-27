package com.login.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    private String userName;
    private String password;
    private String mobileNumber;
}


