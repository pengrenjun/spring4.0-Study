package com.smart.SpringAop2.MethodAdvice.serviceImpl;

import com.smart.SpringAop2.MethodAdvice.service.LogService;
import com.smart.domain.LoginLog;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LogServiceImpl implements LogService {

    private static final Map<Integer,LoginLog> loginLogMap=new ConcurrentHashMap<>();

    @Override
    public void writelogInfo(LoginLog loginLog) {

        loginLogMap.put(loginLog.getLoginLogId(),loginLog);
        System.out.println("记录日志OK!");

    }

    @Override
    public LoginLog queryLogInfo(Integer loginLogId) throws NullPointerException {
        System.out.println("查询日志信息！");
        return loginLogMap.get(loginLogId);
    }



}
