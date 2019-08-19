package org.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka Client服务启动类
 * @author gaomeiling
 * @date 2019年8月14日
 */
@EnableEurekaClient // 开启Eureka Client服务
@SpringBootApplication
public class EurekaClientApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaClientApp.class, args);
    }
}
