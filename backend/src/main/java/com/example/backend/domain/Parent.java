package com.example.backend.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;

    //Child:parent(N:1)
    @OneToMany(mappedBy = "parent" , cascade = CascadeType.ALL)
    private List<Child> childList = new ArrayList<>();
    
    
    //관계 매서드
    // Child 에 있는  setParet 를 parent 도메인에 addChild 메서드를 만들어 서로를 참조하게 만들어 준다
    public void addChild(Child child){
        this.childList.add(child);
        child.setParent(this);
    }

    protected  Parent(){}; // 엔티티에서 관리할수있는 기본생성자가 필요

    public Parent(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
