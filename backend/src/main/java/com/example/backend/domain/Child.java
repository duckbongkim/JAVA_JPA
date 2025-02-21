package com.example.backend.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String longID;
    @Column
    private String password;
    @Column
    private String name;

    // 관계설정 Child - Parent (N:1)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;



    protected Child(){}


    // 생성자 맴버변수의 초기값을 설정해주는거
    // 초기값을 안받아도 되는 맴버변수는 생성자에서 빼도 됨
    public Child(String longID, String password, String name) {
        this.longID = longID;
        this.password = password;
        this.name = name;
    }

    // Child-Personality
    @ManyToMany
    // 차일드가 보내는 값의 컬럼
    @JoinTable(name = "child_personality",
            joinColumns = @JoinColumn(name = "child_id"),
            // 상태 테이블의 id 를 받아옴
            inverseJoinColumns = @JoinColumn(name = "personality_id")
    )
    private List<Personality> personalityList = new ArrayList<>();

    
    //child - Personality 관계 설정 매서드
    public void addPersonality(Personality personality){
        this.personalityList.add(personality);
        personality.getChildList().add(this);
    }

    public Long getId() {
        return id;
    }

    public String getLongID() {
        return longID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setLongID(String longID) {
        this.longID = longID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<Personality> getPersonalityList() {
        return personalityList;
    }
}
