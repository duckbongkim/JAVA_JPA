package com.example.backend.dto.request;

public class ParentRequest {
    private String email;
    private String name;

    public ParentRequest(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
