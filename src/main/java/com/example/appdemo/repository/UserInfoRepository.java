package com.example.appdemo.repository;

import com.example.appdemo.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    boolean existsById(Long id);

    boolean existsByUserName(String userName);
}
