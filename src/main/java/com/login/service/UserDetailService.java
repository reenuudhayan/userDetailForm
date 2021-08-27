package com.login.service;

import com.login.dto.response.UserProfileResponse;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.ws.rs.NotAuthorizedException;

@Service
@Component
public interface UserDetailService {
    AccessTokenResponse login(KeycloakUser user) throws NotAuthorizedException;
    UserProfileResponse getUserProfile(String accessToken);
    String getUserId(String accessToken);
    AccessTokenResponse refreshAccessToken(String refreshToken);

}

