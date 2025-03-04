package com.example.backend.dto.user.response;

public class UserResponse {
    private Long id;
    private String name;
    private Integer age;

    public UserResponse(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
