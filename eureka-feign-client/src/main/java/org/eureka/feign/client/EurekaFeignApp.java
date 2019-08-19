package org.eureka.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign启动类
 * @author gaomeiling
 * @date 2019年8月19日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 启动Feign Client服务
public class EurekaFeignApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaFeignApp.class, args);
    }
}
