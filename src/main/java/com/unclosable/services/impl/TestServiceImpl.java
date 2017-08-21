package com.unclosable.services.impl;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.unclosable.DO.Test;
import com.unclosable.DO.TestExample;
import com.unclosable.mappers.TestMapper;
import com.unclosable.services.TestService;

@Service
public class TestServiceImpl implements TestService {
	protected Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private TestMapper testMapper;

	@Override
	public List<Test> getTest() {
		return this.testMapper.selectByExample(new TestExample());
	}

	@Override
	public URI serviceUrl() {
		return null;
	}

}
