package org.eureka.ribbon.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;
	public String hi(String name){
		return restTemplate.getForObject("http://eureka-client/hi?name="+name, String.class);
	}
	
	/*
	 * 负载均衡器的核心类
	 */
	@Autowired
	private LoadBalancerClient loadBalancer; 
	@GetMapping("/testRibbon")
	public String testRibbon(){
		// 选择一个eureka-client的服务实例信息
		ServiceInstance instance = loadBalancer.choose("eureka-client"); 
		return instance.getHost()+":"+instance.getPort();
	}
}
