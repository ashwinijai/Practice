package com.first.springboot.Practice.service;

import com.first.springboot.Practice.entity.User;
import com.first.springboot.Practice.model.UserResponse;
import com.first.springboot.Practice.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRespository userRespository;

    @Override
    public UserResponse getUser(Long id) {
        User user = userRespository.findByEmpNo(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getEmpNo());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }

    @Override
    public String saveUser(UserResponse userResponse) {
        User user = new User();
        user.setEmpNo(userResponse.getId());
        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        userRespository.save(user);
        return "User added successfully";
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRespository.getAllUsers();
        List<UserResponse> responseList = new ArrayList<>();
        for (User u:users){
            UserResponse userResponse = new UserResponse();
            userResponse.setId(u.getEmpNo());
            userResponse.setFirstName(u.getFirstName());
            userResponse.setLastName(u.getLastName());
            responseList.add(userResponse);
        }
        return responseList;
    }
}
