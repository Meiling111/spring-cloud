package org.eureka.feign.client.component;

import org.eureka.feign.client.feign.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * 熔断器的逻辑处理类
 * @author gaomeiling
 * @date 2019年8月27日
 *
 */
@Component // 注入IOC容器
public class HiHystrix implements EurekaClientFeign{
	@Override
	public String sayHiFromClientEureka(String name){
		return "hi,"+name+",sorry,error!";
	}
}
