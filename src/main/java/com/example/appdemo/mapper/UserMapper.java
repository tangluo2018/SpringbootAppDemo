package com.example.appdemo.mapper;

import com.example.appdemo.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT *FROM user")
    List<User> findAll();

//    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    //@Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")
    void updateById(User user);

    @Delete("DELETE From user WHERE id=#{id}")
    void deleteById(@Param("id") Long Id);
}
