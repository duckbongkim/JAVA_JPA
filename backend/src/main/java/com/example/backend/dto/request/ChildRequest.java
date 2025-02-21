package com.example.backend.dto.request;

public class ChildRequest {

    private String LoginId;
    private String password;
    private String name;

    public ChildRequest(String loginId, String password, String name) {
        LoginId = loginId;
        this.password = password;
        this.name = name;
    }

    public String getLoginId() {
        return LoginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
