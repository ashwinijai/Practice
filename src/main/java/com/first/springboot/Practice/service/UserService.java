package com.first.springboot.Practice.service;

import com.first.springboot.Practice.model.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getUser(Long id);

    String saveUser(UserResponse userResponse);

    List<UserResponse> getAllUsers();
}
