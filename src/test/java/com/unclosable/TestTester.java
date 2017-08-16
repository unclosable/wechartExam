package com.unclosable;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.unclosable.mappers.TestMapper;

/**
 * Created by liuhaibao on 15/11/2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ImportResource("classpath:config/applicationContext.xml")
public class TestTester {
	@Resource
	private TestMapper testMapper;

	@Test
	public void testSave() {
		com.unclosable.DO.Test test = new com.unclosable.DO.Test();
		test.setContent("test content");
		test.setTitle("test title");
		this.testMapper.insert(test);
		System.out.println(test.getId());
	}

}
