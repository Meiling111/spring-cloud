package org.eureka.feign.client.service;

import org.eureka.feign.client.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Feign Client服务实现服务类
 * 
 * @author gaomeiling
 * @date 2019年8月20日
 *
 */
@Service
public class HiService {

	@Autowired
	EurekaClientFeign eurekaClientFeign;
	
	public String sayHi(String name){
		return eurekaClientFeign.sayHiFromClientEureka(name);
	}
}
