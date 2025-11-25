package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
  	<!-- 데이터베이스 정보 모아서 관리 : DataSource -->
	<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="30"
		p:maxIdle="10"
		p:maxWait="-1"/>

    <bean id="dataSource" 
          class="net.sf.log4jdbc.Log4jdbcProxyDataSource"> 
      <constructor-arg ref="ds" /> 
      <property name="logFormatter"> 
        <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter"> 
        <property name="loggingType" value="MULTI_LINE" /> 
        <property name="sqlPrefix" value="SQL : "/> 
        </bean> 
      </property> 
    </bean>
 */
@Configuration

@MapperScan(basePackages = "com.sist.mapper")
public class DatabaseConfig {
	/*
	  	<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="30"
		p:maxIdle="10"
		p:maxWait="-1"/>
	 */
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(30);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlsessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
}
