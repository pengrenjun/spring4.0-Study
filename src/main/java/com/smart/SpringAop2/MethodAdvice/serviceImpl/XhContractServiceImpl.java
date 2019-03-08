package com.smart.SpringAop2.MethodAdvice.serviceImpl;

import com.smart.SpringAop2.MethodAdvice.service.XhContractService;
import com.smart.domain.XhContractExecution;

public class XhContractServiceImpl implements XhContractService {
    @Override
    public XhContractExecution addContract(XhContractExecution xhContractExecution) {
        System.out.println("添加合同信息！");
        return xhContractExecution;
    }
}
