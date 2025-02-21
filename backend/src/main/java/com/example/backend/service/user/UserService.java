package com.example.backend.service.user;

import com.example.backend.dto.user.request.UserCreateRequest;
import com.example.backend.dto.user.response.UserResponse;
import com.example.backend.repository.user.UserRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.util.List;


// 비즈니스 로직을 수행
// 컨트롤러에서 받은 데이터를 레퍼지토리로 전달 하는 역할
// 추가 검증

@Service
public class UserService {
    private final UserRepositoryJDBC userRepositoryJDBC;


//    public UserService(JdbcTemplate jdbcTemplate) {
//        this.userRepository = new UserRepository(jdbcTemplate);
//    }


    public UserService(UserRepositoryJDBC userRepositoryJDBC) {
        this.userRepositoryJDBC = userRepositoryJDBC;
    }

    public void saveUser(UserCreateRequest request){
        userRepositoryJDBC.saveUser(request.getName(), request.getAge());
    }

    public void updateUser(Long id, UserCreateRequest request){
        userRepositoryJDBC.updateUser(id, request.getName(), request.getAge());
    }

    public void deleteUser(Long id){
        userRepositoryJDBC.deleteUser(id);
    }

    public List<UserResponse> getAllUsers(){
        return userRepositoryJDBC.getAllUsers();
    }

    public UserResponse getUserById(Long id){
       return userRepositoryJDBC.getUserById(id);
    }



}
