package com.novel.NovelProject.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("com.novel.NovelProject.mapper")
public class MyBatisConfig {
  @Bean
  public SqlSessionFactory sqlSessionFactory() {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource());
    try {
		return factoryBean.getObject();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return null;
  }

  @Bean
  public DataSource dataSource() {
	  HikariConfig config = new HikariConfig();
	  config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	  config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:system");
	  config.setUsername("novel");
	  config.setPassword("1234");
	 
	  HikariDataSource ds = new HikariDataSource(config);
	return ds;
}
}
