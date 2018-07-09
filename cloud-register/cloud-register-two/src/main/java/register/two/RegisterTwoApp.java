package register.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther 创建者: Tc李
 * @Date 创建时间: 2018/07/09 07:28
 * @Description 类描述:
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterTwoApp {
    public static void main(String[] args) {
        SpringApplication.run(RegisterTwoApp.class,args);
    }
}
