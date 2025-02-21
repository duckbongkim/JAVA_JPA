package com.example.backend.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personalityName;

    //child - personality (N:N)
    @ManyToMany(mappedBy =  "personalityList")
    private List<Child> childList = new ArrayList<>();

    //personality - child 관계 매서드
    public void addChild(Child child){
        this.childList.add(child);
        child.getPersonalityList().add(this);
    }

    protected Personality(){};

    public Personality(String personalityName) {
        this.personalityName = personalityName;
    }

    public Long getId() {
        return id;
    }

    public String getPersonalityName() {
        return personalityName;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName;
    }
}
