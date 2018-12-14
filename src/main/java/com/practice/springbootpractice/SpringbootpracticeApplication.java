package com.practice.springbootpractice;

import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringbootpracticeApplication implements CommandLineRunner, ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootpracticeApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext run = app.run(args);
		Stream.of(run.getBeanDefinitionNames()).filter(s -> !s.contains("spring")).forEach(System.out::println);
		SomeBean bean = run.getBean("somebean", SomeBean.class);
		bean.doSomeThing();
		//		SpringApplication.run(SpringbootpracticeApplication.class, args);
	}
	
	@Configuration
	static class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
		@Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new Formatter());
        }
	}

	@Bean
	public SomeBean somebean(){
		return new SomeBean();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Command Line runner is running");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Application Runner is running" + args);
		
	}

	
	static class SomeBean {
		
		@PostConstruct
		public void post_construct(){
			System.out.println("Post Construct");
		}
		
		public void doSomeThing(){
			System.out.println("Bean created");
		}
		
		@PreDestroy
		public void pre_Destroy(){
			System.out.println("Pre Destroy method invoked");
		}
	}
}

