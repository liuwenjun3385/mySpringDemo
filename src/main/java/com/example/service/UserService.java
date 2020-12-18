package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

@Service
public class UserService implements IServices  {

    @Autowired
     private UserMapper userMapper;


    @Override
    public User findAll(int id) {

        System.out.println("=======1===="+id);
         User us =  userMapper.findAll(id);
        System.out.println("======2====="+id);
        return us;
    }
}
