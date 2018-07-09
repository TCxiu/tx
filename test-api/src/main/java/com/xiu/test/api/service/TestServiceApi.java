package com.xiu.test.api.service;

import com.douyoudian.tx.annotation.TxTransaction;
import com.xiu.test.api.client.TestServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.service.api.model.Test;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 13:04
 * @Description 类描述:
 */

@Service
public class TestServiceApi {

    @Autowired
    TestServiceClient testServiceClient;

    @Transactional
    @TxTransaction(isStart = true)
    public Boolean addTest(Test test){
        Boolean a = testServiceClient.addTest(test);

        int num = 1 / 0 ;
        Boolean b = testServiceClient.addTest(test);

        return true;
    }

}
