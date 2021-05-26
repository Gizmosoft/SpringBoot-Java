package com.accenture.lkm.web.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.accenture.lkm.web.springconf.SpringRootContext;
import com.accenture.lkm.web.springconf.SpringWebContextConfigurator;
//AnnotationConfigDispatcherServletInitializer
public class JavaWebIntializerOrWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {

	// for root context
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringRootContext.class};
	}

	// for web context
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringWebContextConfigurator.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/", "*.html" };
	}
	

}

/* Equivalent web.xml
 * <?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://java.sun.com/xml/ns/javaee"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	version="3.0">
	<welcome-file-list>
		<welcome-file>index.jsp</welcome-file>
	</welcome-file-list>
	<servlet>
		<servlet-name>spring-web</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>spring-web</servlet-name>
		<url-pattern>*.html</url-pattern>
	</servlet-mapping>


	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:com/accenture/resources/myspringroot.xml</param-value>
	</context-param>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
 * */
