package com.login.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.login.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotAuthorizedException;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private final UserDetailService userDetailService;

    public AccessTokenResponse login(String userName, String password) throws NotAuthorizedException {
        KeycloakUser user = new KeycloakUser();
        user.setUserName(userName);
        user.setPassword(password);
        return UserDetailService.login(user);
    }
}
