package com.login.service.impl;

import com.login.dao.Dao;
import com.login.dto.response.UserProfileResponse;
import com.login.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotAuthorizedException;

@Service
@Component
@RequiredArgsConstructor
public class ServiceImpl implements UserDetailService {
    private Logger log = LoggerFactory.getLogger(UserDetailService.class);


    @Autowired
    private Dao Dao;

    @Override
    public AccessTokenResponse login(KeycloakUser user) throws NotAuthorizedException {
        try {
            Keycloak keycloak = KeyCloakUtil.getKeyCloakClient(user);
            return keycloak.tokenManager().grantToken();
        } catch (Exception ex) {
            log.error("Incorrect email or password", ex);
            throw new NotAuthorizedException("Incorrect email or password");
        }
    }

    @Override
    public UserProfileResponse getUserProfile(String accessToken) {

            UserProfileResponse response = KeyCloakUtil.getUserProfile(accessToken);
            return response;
    }

    @Override
    public AccessTokenResponse refreshAccessToken(String refreshToken) {
        public AccessTokenResponse refreshAccessToken(String refreshToken) {
            return KeyCloakUtil.refreshAccessToken(refreshToken);
        }
    }
}