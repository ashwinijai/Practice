package com.first.springboot.Practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TABLE")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name ="EMP_NO")
    Long empNo;
    @Column(name ="FIRST_NAME")
    String firstName;
    @Column(name ="LAST_NAME")
    String lastName;
}
