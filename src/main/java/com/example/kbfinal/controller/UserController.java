package com.example.kbfinal.controller;
import com.example.kbfinal.entity.User;
import com.example.kbfinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // user 정보를 입력, 삭제, 수정하는 API 생성
    //등록
    @PostMapping("/regist")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User registUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registUser);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    // 전체 user List를 조회하는 api 생성
    @GetMapping("/getAllUsers")
    public List<User> findAll(){
        return userService.findAll();
    }

    // 전체 사용자 수 조회
    @GetMapping("/count")
    public ResponseEntity<Long> countUser() {
        long count = userService.countUser();
        return ResponseEntity.ok(count);
    }

}
