package com.practice.springbootpractice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringbootpracticeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootpracticeApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		//		SpringApplication.run(SpringbootpracticeApplication.class, args);
	}
	
	@Configuration
	static class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
		@Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new Formatter());
        }
		
	}

}

