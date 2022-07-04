package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("demoMappingConfiguration")
public class MappingConfiguration {
	@Bean
	public DemoMapper studentMapper() {
		return new DemoMapper();
	}

	@Bean
	public TrabajadorMapper trabajadorMapper() {
		return new TrabajadorMapper();
	}

	@Bean
	public ViaticoMapper viaticoMapper() {
		return new ViaticoMapper();
	}
}