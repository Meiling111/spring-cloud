package org.eureka.ribbon.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

	/**
	 * 在程序的Ioc容器中注入一个restTemplate的bean，为bean注解@loadBalanced
	 * 此时RestTemplate已结合Ribbon开启了负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
