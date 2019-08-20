package org.eureka.feign.client.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

/**
 * Feign Client的配置类
 * @author gaomeiling
 * @date 2019年8月20日
 *
 */
@Configuration // 声明该类是配置类
public class FeignConfig {

	@Bean
	public Retryer feignRetryer(){
		// 更改该FeignClient的请求失败重试策略，重试间隔为100毫秒，最大重试时间为1秒，重试次数为5次
		return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
	}
}
