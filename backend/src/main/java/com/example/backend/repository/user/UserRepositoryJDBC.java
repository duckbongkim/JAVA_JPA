package com.example.backend.repository.user;

import com.example.backend.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//DB에대한 요청들을 처리 하는 요청
//DB에 직접 견결 하는 작업
//jdbc를 사용하여 sql을 DB로 보내는 작업
@Repository
public class UserRepositoryJDBC {
    private final JdbcTemplate jdbcTemplate;



    public UserRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Post 사용자 입력 요청
    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql, name,age);
    }

    // Put 사용자 정보 수정
    public void updateUser(Long id, String name, Integer age){
        String sql = "UPDATE user SET name = ?, age =? WHERE id = ?";
        jdbcTemplate.update(sql,name,age,id);
    }

    //delete 사용자 정보 삭제
    public void deleteUser(Long id){
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public UserResponse getUserById(Long id){
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }


    public List<UserResponse> getAllUsers(){
        String sql = "SELECT*FROM user";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    private final RowMapper<UserResponse> userRowMapper = (rs, rowNum) ->
            new UserResponse(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));

}








