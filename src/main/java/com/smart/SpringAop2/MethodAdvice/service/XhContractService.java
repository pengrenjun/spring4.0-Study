package com.smart.SpringAop2.MethodAdvice.service;

import com.smart.domain.User;
import com.smart.domain.XhContractExecution;

public interface XhContractService {

    /**添加合同*/
    XhContractExecution addContract(XhContractExecution xhContractExecution);


}
