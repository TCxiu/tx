package test.service.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 11:01
 * @Description 类描述:
 */

@SpringBootApplication
@MapperScan(basePackages = "test.service.provider.mapper")
@EnableEurekaClient
public class TestServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApp.class,args);
    }
}
