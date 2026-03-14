package com.example.appdemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="t_user_info")
public class UserInfo {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_user_info_seq")
    @SequenceGenerator(name = "t_user_info_seq", allocationSize = 1)
    @Column(name = "user_id",columnDefinition = "bigint(16) COMMENT 'id'",nullable = false, unique = true)
    private Long id;

    @Column(name = "user_name",columnDefinition = "varchar(16) COMMENT 'name'",nullable = true)
    private String userName;

    @Column(name = "user_age",columnDefinition = "int(16) COMMENT 'name'",nullable = true)
    private int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
