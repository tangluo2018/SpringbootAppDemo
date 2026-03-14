package com.example.appdemo.services;

import com.example.appdemo.entities.UserInfo;
import com.example.appdemo.repository.UserInfoRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Transactional
    public void saveUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getUserInfoList(){
        //System.out.println();
        return userInfoRepository.findAll();
    }
}
