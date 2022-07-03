package com.ebsi657.marquinavichinoadrian202017487.demo.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("demoMappingConfiguration")
public class MappingConfiguration {
	@Bean
	public DemoMapper studentMapper() {
		return new DemoMapper();
	}
}