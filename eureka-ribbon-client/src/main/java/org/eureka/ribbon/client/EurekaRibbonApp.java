package org.eureka.ribbon.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Ribbon负载均衡启动类
 * @author gaomeiling
 * @date 2019年8月17日
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaRibbonApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaRibbonApp.class, args);
    }
}
