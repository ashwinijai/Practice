package com.first.springboot.Practice.controller;

import com.first.springboot.Practice.model.UserResponse;
import com.first.springboot.Practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PracticeController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")  //pathParam  /user/1
    //200 - Success
    //201 - Created  (POST)
    //400 - Bad Request
    //404 - Not Found
    //409 - Conflict
    //500 - Internal Server Error

    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id){
        UserResponse userResponse = userService.getUser(id);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserResponse userResponse){
        String response = userService.saveUser(userResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> responseList = userService.getAllUsers();
        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }
}
