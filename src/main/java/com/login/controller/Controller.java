package com.login.controller;

import com.google.common.util.concurrent.Service;
import com.login.dto.response.AccessTokenResponse;
import com.login.dto.response.UserProfileResponse;
import com.login.model.UserProfile;
import com.login.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class Controller {

    @Autowired
    private final Service Service;

    ModelMapper mapper = new ModelMapper();

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@Validated @RequestBody KeycloakUser user) {
        return ResponseEntity.ok(mapper.map(UserDetailService.login(user), AccessTokenResponse.class));
    }

    @GetMapping("/users/currentUser")
    public ResponseEntity<UserProfileResponse> getUserProfile(@RequestHeader(value = "Authorization") final String accessToken) {
        return ResponseEntity.ok(Service.getUserProfile(accessToken));
    }

    @PostMapping("/refreshAccessToken")
    public ResponseEntity<AccessTokenResponse> refreshAccessToken(@RequestBody final UserProfile userProfile) {
        return ResponseEntity.ok(mapper.map(UserDetailService.refreshAccessToken(userProfile.getRefreshToken()), AccessTokenResponse.class));
    }
}




