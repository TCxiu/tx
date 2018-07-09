package com.xiu.test.api.client;

import com.xiu.test.api.client.hystrix.TestServiceClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import test.service.api.service.TestService;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 12:58
 * @Description 类描述:
 */

@FeignClient(name = "test-service-provider",fallback = TestServiceClientHystrix.class)
@Component
public interface TestServiceClient extends TestService {
}
