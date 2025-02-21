package com.example.backend.dto.request;

public class ChildPersonalityRequest {

    private String longinID;
    private String password;
    private String name;

    private String personalityName;

    public ChildPersonalityRequest(String longinID, String password, String name, String personalityName) {
        this.longinID = longinID;
        this.password = password;
        this.name = name;
        this.personalityName = personalityName;
    }

    public String getLonginID() {
        return longinID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPersonalityName() {
        return personalityName;
    }


}

