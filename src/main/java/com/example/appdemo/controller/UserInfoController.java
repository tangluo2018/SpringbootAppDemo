package com.example.appdemo.controller;

import com.example.appdemo.annotation.SaveAnnotation;
import com.example.appdemo.entities.UserInfo;
import com.example.appdemo.services.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    private final  UserInfoService userInfoService;

    //private UserInfo userInfo;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping("/getuser")
    public List<UserInfo> getUserInfoAll(){
        return userInfoService.getUserInfoList();
    }

    @RequestMapping("/saveuser")
    @SaveAnnotation
    public void saveUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAge(38);
        userInfo.setUserName("Test1");
        userInfoService.saveUserInfo(userInfo);
    }

}
