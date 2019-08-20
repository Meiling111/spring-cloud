package org.eureka.feign.client.controller;

import org.eureka.feign.client.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign Client控制器
 * @author gaomeiling
 * @date 2019年8月20日
 *
 */
@RestController
public class HiController {

	@Autowired
	private HiService hiService;
	@GetMapping("/hi")
	public String sayHi(@RequestParam(defaultValue = "forezp", required = false)String name){
		return hiService.sayHi(name);
	}
}
