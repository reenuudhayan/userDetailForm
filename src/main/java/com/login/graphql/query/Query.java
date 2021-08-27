package com.login.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.login.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private UserDetailService userDetailService;

    public String getUserId(String accessToken) throws Exception {
        return UserDetailService.getUserId(formatAccessToken(accessToken));

        private String formatAccessToken(String accessToken){
            return "{ " + accessToken + " }";
        }

    }
}
