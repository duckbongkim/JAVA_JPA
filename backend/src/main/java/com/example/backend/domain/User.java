package com.example.backend.domain;
// domain >> 익스프레스에 models 처럼 티비 테이블들을 저장하는 패키지

import jakarta.persistence.*;

@Entity // JPA 가 이 클래스를 엔티티로 인식하도록 설정
@Table(name="user") // DB의 테이블 명
public class User {
    @Id // 기본키 (PK) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB 에서 자동 증가 하는 값
    private Long id;
    
    @Column(nullable = false,length = 25, name = "name") // NOT NULL 로 설정함
    private String name;

    @Column(nullable = true) // nullable 기본설정은 true 임
    private Integer age;

    protected User(){} // jpa 에서는 기본 생성자가 필수


    public User(String name, Integer age) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
        }
        this.name = name;
        this.age = age;
    }


    //cascade >> 참조하고 있는 데이터가 삭데되면 같이 삭제됨
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;



    public void setProfile(Profile profile){
        this.profile = profile; // 유저에서 프로파일을 참조하고있는 관계 // user 가 profile 을 저장함
        profile.setUser(this); // 프로파일이 호출되었을때 user 를 불러옴 // profile이 user를 저장함
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


    public void updateName(String name){
        this.name = name;
    }


}
