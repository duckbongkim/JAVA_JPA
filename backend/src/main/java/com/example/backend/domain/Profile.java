package com.example.backend.domain;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Profile() {};

    public void setUser(User user) {
        this.user = user;
    }
}
