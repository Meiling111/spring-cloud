package org.eureka.feign.client.feign;

import org.eureka.feign.client.component.HiHystrix;
import org.eureka.feign.client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 实现一个简单的Feign Client
 * @author gaomeiling
 * @date 2019年8月20日
 *
 */
/*
 * 声明一个Feign Client
 * value：远程调用其他服务的服务名
 * FeignConfig为Feign Client的配置类
 */
@FeignClient(value="eureka-client",configuration=FeignConfig.class, fallback= HiHystrix.class)
public interface EurekaClientFeign {
	@GetMapping(value="/hi")
	String sayHiFromClientEureka(@RequestParam(value="name")String name);
}
