package com.practice.springbootpractice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.practice.springbootpractice.exitcode.CheckExitCodeGeneratorException;

@SpringBootApplication
public class SpringbootpracticeApplication implements CommandLineRunner, ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootpracticeApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext run = app.run(args);
		// Commented the following as it prints all bean names
		//Stream.of(run.getBeanDefinitionNames()).filter(s -> !s.contains("spring")).forEach(System.out::println);
		
		SomeBean bean = run.getBean("somebean", SomeBean.class);
		bean.doSomeThing();
		//		SpringApplication.run(SpringbootpracticeApplication.class, args);
		//Commented the following as it exits the application
		//SpringApplication.exit(run, new MyExitCodeGenerator());
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
		//if the runtime exception is thrown, there should be a class that implements ExitCodeGenerator, 
		// extends RunTimeExceptions and a new class to listen to the event, hence commented the following code
		// throw new CheckExitCodeGeneratorException();
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
		
		@EventListener
		public void listenToExitCode(ExitCodeEvent exp){
			System.out.println("----------------------------------------------------------");
			System.out.println("Return code" + exp.getExitCode());
		}
		
		@EventListener
		public void printEvents(Object event){
			System.out.println("EVENT -------- " + event);
		}
	}
}

