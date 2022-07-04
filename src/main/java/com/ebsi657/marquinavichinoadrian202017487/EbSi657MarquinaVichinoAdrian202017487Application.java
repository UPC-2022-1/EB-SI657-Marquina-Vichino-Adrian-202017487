package com.ebsi657.marquinavichinoadrian202017487;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class EbSi657MarquinaVichinoAdrian202017487Application {

	public static void main(String[] args) {
		SpringApplication.run(EbSi657MarquinaVichinoAdrian202017487Application.class, args);
	}

	@Configuration
	public static class WebConfiguration implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*");
		}
	}

	@Controller
	public static class HomeController {
		@RequestMapping("/")
		public String welcome() {
			return "index";
		}
	}
}
