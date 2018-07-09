package com.xiu.test.api.client.hystrix;

import com.xiu.test.api.client.TestServiceClient;
import org.springframework.stereotype.Component;
import test.service.api.model.Test;

import java.util.List;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 13:02
 * @Description 类描述:
 */

@Component
public class TestServiceClientHystrix implements TestServiceClient {
    @Override
    public Boolean addTest(Test test) {
        return null;
    }

    @Override
    public Boolean delTestById(Long id) {
        return null;
    }

    @Override
    public Boolean updateTestById(Long id, Test record) {
        return null;
    }

    @Override
    public Test findById(Long id) {
        return null;
    }

    @Override
    public List<Test> listTest() {
        return null;
    }
}
