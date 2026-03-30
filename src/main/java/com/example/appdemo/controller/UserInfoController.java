package com.example.appdemo.controller;

import com.example.appdemo.annotation.SaveAnnotation;
import com.example.appdemo.entities.User;
import com.example.appdemo.entities.UserInfo;
import com.example.appdemo.services.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/all")
    public List<User> getAllUserInfo(){
        return userInfoService.getAllUsers();
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        userInfoService.deleteUserById(id);
        return "delete user successful";
    }

    @RequestMapping("/update/{id}")
    public String updateUserById(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Mybatis Test2");
        user.setAge(40);
        userInfoService.updateUserById(user);
        return "update user successful";
    }

    @RequestMapping("/save")
    public String saveUser(){
        User user = new User();
        user.setName("Mybatis Test");
        user.setAge(30);
        userInfoService.saveUser(user);
        return "save user successful";
    }

    @RequestMapping("/saveuser")
    @SaveAnnotation
    public void saveUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAge(38);
        userInfo.setUserName("Test1");
        userInfoService.saveUserInfo(userInfo);
    }

    @RequestMapping("/create")
    public void createUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAge(38);
        userInfo.setUserName("Test1");
        userInfoService.createUserWithRollback(userInfo);
        System.out.println("Create user successful");
    }

}
