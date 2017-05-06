package com.unclosable.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.unclosable.DO.Test;
import com.unclosable.DO.TestExample;
import com.unclosable.mappers.TestMapper;
import com.unclosable.services.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TestMapper testMapper;
	@Override
	public List<Test> getTest() {
		TestExample example = new TestExample();
		return testMapper.selectByExample(example);
	}

}
