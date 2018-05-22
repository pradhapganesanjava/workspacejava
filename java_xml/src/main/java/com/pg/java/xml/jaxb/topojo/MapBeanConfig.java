package com.pg.java.xml.jaxb.topojo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapBeanConfig {

	@Bean(autowire= Autowire.BY_NAME)
	public Map<String, String> mps(){
		Map<String, String> mpStr = new HashMap<String, String>();
		mpStr.put("1", "PGanesan 1");
		mpStr.put("2", "PGanesan 2");
		mpStr.put("3", "PGanesan 3");
		return mpStr;
	}
}
