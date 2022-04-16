package com.sb.formation.reponses;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long code;
    private String login;
    private List<String> roles;

    public JwtResponse(String accessToken, Long code, String login, List<String> roles) {
        this.token = accessToken;
        this.code = code;
        this.login = login;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRoles() {
        return roles;
    }
}

