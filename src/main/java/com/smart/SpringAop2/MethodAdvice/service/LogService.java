package com.smart.SpringAop2.MethodAdvice.service;

import com.smart.domain.LoginLog;

public interface LogService {

    /**记录日志*/
    void writelogInfo(LoginLog loginLog);

    /**查询日志*/
    LoginLog queryLogInfo(Integer loginLogId) throws NullPointerException;
}
