package com.unclosable.services.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.unclosable.DO.Test;
import com.unclosable.services.TestService;

@Service
public class TestServiceImpl implements TestService {
	protected Log logger = LogFactory.getLog(this.getClass());

	// @Resource
	// private TestMapper testMapper;

	@Override
	public List<Test> getTest() {
		Test a = new Test();
		a.setContent("123");
		return Arrays.asList(a);
	}

	@Override
	public URI serviceUrl() {
		return null;
	}

}
