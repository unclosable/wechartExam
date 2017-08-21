package com.unclosable;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MyBatisConfiguration {

	@Bean(name = "mysqlSessionFactory")
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DruidDataSource dataSource) throws IOException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new ClassPathResource("/config/mybatis/mybatis-config.xml"));
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 只加载一个绝对匹配Resource，且通过ResourceLoader.getResource进行加载
		Resource[] resources = resolver.getResources("/config/mybatis/mappers/*.xml");
		bean.setMapperLocations(resources);
		return bean;
	}

	// @Bean
	// public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactoryBean
	// sqlSessionFactory) throws Exception {
	// SqlSessionTemplate template = new
	// SqlSessionTemplate(sqlSessionFactory.getObject());
	// return template;
	// }

	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.unclosable.mappers");
		configurer.setSqlSessionFactoryBeanName("mysqlSessionFactory");
		return configurer;
	}
}
