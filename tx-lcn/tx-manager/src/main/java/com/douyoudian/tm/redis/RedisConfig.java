package com.douyoudian.tm.redis;

import io.lettuce.core.ClientOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.time.Duration;

/**
 * Created by lorne on 2017/7/5.
 */

@Configuration
public class RedisConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);



    @Bean
    public RedisConnectionFactory redisConnectionFactory(){

        ClientOptions.Builder clientBuilder = ClientOptions.builder();

        clientBuilder.pingBeforeActivateConnection(true);

        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName("192.168.0.188");
        standaloneConfiguration.setPort(6379);
        standaloneConfiguration.setDatabase(6);

        LettuceClientConfiguration.LettuceClientConfigurationBuilder builder = LettuceClientConfiguration.builder();
        builder.commandTimeout(Duration.ofMinutes(6));
        builder.shutdownTimeout(Duration.ofMinutes(6));
        builder.clientOptions(clientBuilder.build());

        LettuceConnectionFactory factory = new LettuceConnectionFactory(standaloneConfiguration,builder.build());
        return factory;

    }


    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }
}
