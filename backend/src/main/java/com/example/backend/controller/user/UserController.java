package com.example.backend.controller.user;

import com.example.backend.domain.User;
import com.example.backend.dto.user.request.UserCreateRequest;
import com.example.backend.dto.user.response.UserResponse;
import com.example.backend.service.user.UserService;
import com.example.backend.service.user.UserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//@PostMapping("/user") >> 매서드를 실행 >> 요청을 처리 >> service 호출
//Json 데이터를 객체로 변환해서 받아줌
@RestController // 객체화를 시키지 않아도 해당 클래스를 실행시킬수있도록 만들어줌
public class UserController {
    private final UserServiceJPA userService;



//    public UserController(JdbcTemplate jdbcTemplate) {
//        // 인스턴스를 생성해서 사용
//        // 힙영역에 인스턴스를 생성해서 사용
//        this.userService = new UserService(jdbcTemplate);
//    }

    public UserController(UserServiceJPA userService) {
        this.userService = userService;
    };

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
      userService.saveUser(request);
    };

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request){
        userService.updateUser(id,request);
    }
    @DeleteMapping("/{name}")
    public void deleteMapping(@PathVariable String name){
        userService.deleteUser(name);
    }

//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request){
//        userService.updateUser(id,request);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteMapping(@PathVariable Long id){
//        userService.deleteUser(id);
//    }
//
//    @GetMapping("/user")
//    public List<UserResponse> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/user/{id}")
//    public UserResponse getUserById(@PathVariable Long id){
//        return userService.getUserById(id);
//    }
}



// 스프링 서버가 실행되면 컨테이너를 생성
// RstController 어노테이션을 적으면 어노테이션을 찾아서 컨테이너에 해당 클래스가 담김 그걸 bean 이라고 부름


//
