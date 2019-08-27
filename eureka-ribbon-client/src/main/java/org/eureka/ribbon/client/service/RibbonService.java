package org.eureka.ribbon.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 负载均衡实现服务类
 * @author gaomeiling
 * @date 2019年8月20日
 *
 */
@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;
	/*
	 * 使hi()启用Hystrix熔断器的功能
	 * fallbackMethod为处理回退逻辑的方法
	 */
	@HystrixCommand(fallbackMethod="hiError") 
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
	
	/**
	 * 处理回退逻辑的方法
	 * 在熔断器打开的情况下执行
	 * 回退逻辑最好是返回一些静态字符串，不需要处理复杂的逻辑，也不需要远程调度其它服务，这样方便执行快速失败，释放线程资源
	 * @param name
	 * @return
	 * @author gaomeiling
	 * @date 2019年8月20日
	 */
	public String hiError(String name){
		return "hi,"+name+",sorry,error!";
	}
}
