package com.xiu.test.api.controller;

import com.xiu.test.api.service.TestServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.service.api.model.Test;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 13:06
 * @Description 类描述:
 */

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestServiceApi testServiceApi;

    @PostMapping("")
    public Object addTest(@RequestBody Test test){
        Boolean aBoolean = testServiceApi.addTest(test);
        return aBoolean;
    }
}
