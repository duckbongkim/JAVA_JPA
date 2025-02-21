package com.example.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// <User ,Long> >> 도메인의 User 엔터티 , Long User 엔터티에 있는 아이디의 타입
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByName(String name);

    List<User> findAllByName(String name);
}

// User findByName(String name) >> SELECT * FROM user WHERE name = ? 으로 치환해줌
// By 를 기준으로 나뉨
// By 앞은 SELECT * FROM user WHERE 해당
// By 뒤는  name = ? 에 해당
