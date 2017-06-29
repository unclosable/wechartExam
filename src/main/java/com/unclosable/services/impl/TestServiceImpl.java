package com.unclosable.services.impl;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.unclosable.DO.Test;
import com.unclosable.DO.TestExample;
import com.unclosable.mappers.TestMapper;
import com.unclosable.services.TestService;

@Service
public class TestServiceImpl implements TestService {
	protected Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private TestMapper testMapper;

	@Resource
	private DiscoveryClient discoveryClient;

	@Override
	public List<Test> getTest() {
		TestExample example = new TestExample();
		return testMapper.selectByExample(example);
	}

	@Override
	public URI serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("test-webService");
		list.forEach(s -> {

			logger.debug("Secure:" + s.isSecure());
			logger.debug("Host:" + s.getHost());
			logger.debug("Metadata:" + JSON.toJSONString(s.getMetadata()));
		});
		if (list != null && list.size() > 0) {
			return list.get(0).getUri();
		}
		return null;
	}

}
