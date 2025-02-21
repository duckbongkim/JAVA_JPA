package com.example.backend.dto.user.request;
//DTO >> DATA 를 더 안전하게 관리 용이 // 프로세스 간에 데이터를 전달하는 용도의 객체
public class UserCreateRequest {
    private String name;
    private Integer age;

    public UserCreateRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    // 해당값을 단순히 꺼내 쓰기 위해 사용하는 getter
    // 위에 클래스의 값을 변경하기 위해 사용하는 setter
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
