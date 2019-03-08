package com.smart.SpringAop;

import com.smart.SpringAop2.MethodAdvice.service.UserService;
import com.smart.domain.User;

public class UserServiceImpl implements UserService {

    @Override
    public User addUser(User user) {
        System.out.println("添加用户OK!");
        return user;

    }

    @Override
    public User queryUser(Integer userId) throws Exception {
        return new User();
    }
}
