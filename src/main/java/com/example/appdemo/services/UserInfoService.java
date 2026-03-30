package com.example.appdemo.services;

import com.example.appdemo.entities.User;
import com.example.appdemo.entities.UserInfo;
import com.example.appdemo.mapper.UserMapper;
import com.example.appdemo.repository.UserInfoRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    private final UserMapper userMapper;

    public UserInfoService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public void saveUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getUserInfoList(){
        //System.out.println();
        return userInfoRepository.findAll();
    }

    //场景: 事务回滚 - 异常触发, 事务确保：要么三步全成功，要么全不发生。3步必须是针对数据库的操作.
    @Transactional
    public void createUserWithRollback(UserInfo userInfo){
        if(userInfoRepository.existsByUserName(userInfo.getUserName())){
            throw new EntityExistsException("用户已存在: " + userInfo.getUserName());
        }
        // 1. 插入用户
        userInfoRepository.save(userInfo);

        // 2. 操作 orders 表
        //orderRepository.save(order);

        // 3. 操作 accounts 表（扣款）
        //accountRepository.decreaseBalance(userId, order.getAmount());
    }

    public List<User> getAllUsers(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
        return users;
    }

    public void saveUser(User user){
        userMapper.insert(user);
    }

    public void deleteUserById(Long id){
        userMapper.deleteById(id);
    }

    public void updateUserById(User user){
        userMapper.updateById(user);
    }
}
