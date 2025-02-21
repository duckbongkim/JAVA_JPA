package com.example.backend.service.user;

import com.example.backend.domain.Profile;
import com.example.backend.domain.User;
import com.example.backend.domain.UserRepository;
import com.example.backend.dto.user.request.UserCreateRequest;
import com.example.backend.dto.user.response.UserResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceJPA {
    private final UserRepository userRepository;

    public UserServiceJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //post 요청 : 데이터 저장
    @Transactional // 해당 로직이 완벽하게 성공하거나 실패하거나
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
//        throw new IllegalArgumentException();
    }

    //get 요청 :: 사용자 전체 조회
    @Transactional(readOnly = true)
    public List<User>getAllUsers(){
//        return userRepository.findAll().stream()
//                .map(UserResponse::new).collect(Collectors.toList());
        
        
        // 1. userRepository.findAll() >> select * from user 와 동일
        // 2. .stream() >> 자바에 있는 stream 형태로 변환 리스트 형태를 map 을 사용할수있도록 변환
        // 3. map(UserResponse::new) >> 각 요소마다 userRepository 객체로 변환
        // 4. collect(Collectors.toList()) >> List 형태로 반환
        return userRepository.findAll().stream().toList();
    }

    //put 요청 : 정보 수정
    @Transactional
    public void updateUser(Long id, UserCreateRequest request){
        User user = userRepository.findById(id).orElseThrow(IllegalAccessError::new);
        user.updateName(request.getName());
//        userRepository.save(user);
        // 트랙잭션이 붙어있으면 엔티티가 변환되면 자동으로 저장함
    }

    //delete 요청 : 유저 삭제
    @Transactional
    public void deleteUser(String name){
        // 예외처리

        // find : 하나의 데잍처만 찾길 원할때 (2개이상의 데이터가 있으면 안됨)
        // findAll: 여러데이터를 찾길 원할때
//        User user = userRepository.findByName(name); // 이름으로 데이터 찾음
//        if (user == null ) {
//            throw new IllegalArgumentException();
//        }
//        userRepository.delete(user); // 찾은데이터를 삭제
        
        // delete : 객체 하나 삭제
        // deleteAllInBatch : 여러개 삭제
        List<User> user = userRepository.findAllByName(name);
        if (user == null) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteAllInBatch(user);
    }

//영속성 컨텍스트 주요 4가지 기능



}
