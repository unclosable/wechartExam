package com.unclosable.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class TestConsulController {
	@Value("${spring.profiles.active}")
	String profiles;

	@RequestMapping("/")
	public String home() {
		return "Hello World,this is " + profiles + " service";
	}

	@RequestMapping("/{visitor}")
	public String home(@PathVariable String visitor) {
		if (StringUtils.isBlank(visitor)) {
			return "Hello World,this is " + profiles + " service";
		} else {
			return "Hello " + visitor + " , this is " + profiles + " service";
		}
	}
}
