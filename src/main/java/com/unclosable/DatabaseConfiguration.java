package com.unclosable;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DatabaseConfiguration {
	@Value("${spring.datasource.url}")
	String dataUrl;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.driverClassName}")
	String driverClassName;

	@Bean
	public StatFilter getStatFilter() {
		StatFilter filter = new StatFilter();
		filter.setLogSlowSql(true);
		filter.setMergeSql(true);
		filter.setSlowSqlMillis(1000);
		return filter;
	}

	@Bean
	public Log4jFilter getLog4jFilter() {
		Log4jFilter filter = new Log4jFilter();
		filter.setResultSetLogEnabled(true);
		filter.setDataSourceLogEnabled(true);
		return filter;
	}

	@Bean
	public DruidDataSource getDruidDataSource(StatFilter statFilter, Log4jFilter log4jFilter) throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(dataUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		// 初始化连接大小
		dataSource.setInitialSize(10);
		// 连接池最大使用连接数量
		dataSource.setMaxActive(100);
		// 最小连接池数量
		dataSource.setMinIdle(10);
		// 获取连接最大等待时间
		dataSource.setMaxWait(60000);
		dataSource.setTestWhileIdle(true);
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(25200000);
		// 打开removeAbandoned功能
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(1800);
		// 连接时输出错误日志
		dataSource.setLogAbandoned(true);
		// 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
		dataSource.setPoolPreparedStatements(false);
		dataSource.setFilters("config");
		dataSource.setConnectionProperties("config.decrypt=false");
		dataSource.setProxyFilters(Arrays.asList(statFilter, log4jFilter));
		return dataSource;
	}

	// @Bean
	// public DataSourceTransactionManager
	// getDataSourceTransactionManager(DruidDataSource dataSource) {
	// DataSourceTransactionManager dataSourceTransactionManager = new
	// DataSourceTransactionManager(dataSource);
	// return dataSourceTransactionManager;
	// }
}
