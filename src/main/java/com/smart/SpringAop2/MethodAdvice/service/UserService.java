package com.smart.SpringAop2.MethodAdvice.service;

import com.smart.domain.LoginLog;
import com.smart.domain.User;

public interface UserService {

    /**添加用户*/
    User addUser(User user);

    /**查询用户*/
    User queryUser(Integer userId) throws Exception;
}
