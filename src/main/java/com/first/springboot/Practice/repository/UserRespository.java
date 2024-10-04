package com.first.springboot.Practice.repository;

import com.first.springboot.Practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.empNo=?1")
    //select * from USER WHERE ID =
    User findByEmpNo(Long empNo);

    @Query("select u from User u")
    List<User> getAllUsers();
}
