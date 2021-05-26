package com.accenture.lkm.db.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:com/accenture/lkm/resources/cst_conn.properties")
@EnableTransactionManagement //<tx:annotation-driven>
@EnableJpaRepositories(basePackages="com.accenture.lkm.dao",transactionManagerRef="txManager")
//<jpa:repositories base-package="com.accenture.lkm.dao" transaction-manager-ref="txManager"
public class SpringDBConfig {
	
	// reading value from properties file and giving to the datasource
	@Value("${cst_db_driver}")
	private String driverName;
	
	@Value("${cst_db_url}")
	private String url;
	
	@Value("${cst_user}")
	private String userName;
	
	@Value("${cst_password}")
	private String password;
	//To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
			return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource getDataSource() {
		System.out.println(driverName);
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}

	public HibernateJpaVendorAdapter getVendorAdaptor(){
		HibernateJpaVendorAdapter adapter = new  HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}


	@Autowired
	// for wiring the DataSource
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DriverManagerDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factoryBuilder = new LocalContainerEntityManagerFactoryBean();
		factoryBuilder.setDataSource(dataSource);
		factoryBuilder.setJpaVendorAdapter(getVendorAdaptor());
		factoryBuilder.setPackagesToScan("com.accenture.lkm.entity");
		return factoryBuilder;
	}


	
	@Autowired
	// for injecting the session factory inside
	@Bean(name = "txManager")
	public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		return transactionManager;
	}	
	
}
/*
 * 
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans     
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx 
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/data/jpa
        http://www.springframework.org/schema/data/jpa/spring-jpa.xsd">

	
    
    <bean
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">

		<property name="location">
			<value>classpath:com/accenture/lkm/resources/cst_conn.properties</value> <!-- class path is requried when runing from web app -->
		</property>
	</bean>
    
    <tx:annotation-driven transaction-manager="txManager"/>
    <!-- To Enable JPA Repository and to refer to the custom transaction Manager name-->
	<jpa:repositories base-package="com.accenture.lkm.dao" transaction-manager-ref="txManager"> </jpa:repositories>
    
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource" >
        <property name="driverClassName" value="${cst_db_driver}" />
        <property name="url" value="${cst_db_url}" />
        <property name="username" value="${cst_user}" />
        <property name="password" value="${cst_password}" />
    </bean>
 
 
	<!-- Name of the bean should be entity manager factory only in spring JPA data-->
    <bean id="entityManagerFactory"	class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
				<property name="showSql" value="true" />
				<property name="generateDdl" value="true" />
				<property name="databasePlatform" value="org.hibernate.dialect.MySQLDialect" />
			</bean>
		</property>
		<property name="packagesToScan" value="com.accenture.lkm.entity"></property>
	</bean>
	
	<bean id="txManager" class="org.springframework.orm.jpa.JpaTransactionManager"> <!--  custom transaction Manager -->
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>
	
</beans>
 * 
 * 
 * */
