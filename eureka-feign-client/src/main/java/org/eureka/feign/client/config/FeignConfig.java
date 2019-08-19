package org.eureka.feign.client.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration // 该类是一个配置类
public class FeignConfig {

	/*
	 * 注入该bean后，Feign在远程调用失败后会重试
	 */
	@Bean
	public Retryer feignRetryer(){
		return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
	}
}
