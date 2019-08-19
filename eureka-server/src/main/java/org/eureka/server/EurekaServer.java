package org.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka-server 启动类
 * @author gaomeiling
 * @date 2019年8月14日
 */
@EnableEurekaServer // 开启Eureka Server功能
@SpringBootApplication
public class EurekaServer 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaServer.class, args);
    }
}
