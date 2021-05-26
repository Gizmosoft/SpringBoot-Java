package com.accenture.lkm.web.springconf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.accenture.lkm.db.config.SpringDBConfig;

@Configuration
@ComponentScan({"com.accenture.lkm.dao","com.accenture.lkm.service"})
@Import(SpringDBConfig.class)
public class SpringRootContext {

}
