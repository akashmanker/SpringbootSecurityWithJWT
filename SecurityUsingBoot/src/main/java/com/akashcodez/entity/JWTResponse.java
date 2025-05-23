package com.akashcodez.entity;

import lombok.Builder;

@Builder
public class JWTResponse {

    String token;
    String username;

    public JWTResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }


    public JWTResponse() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
