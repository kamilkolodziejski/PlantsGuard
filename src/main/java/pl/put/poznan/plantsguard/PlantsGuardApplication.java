package pl.put.poznan.plantsguard;

import java.util.Arrays;

import javax.servlet.Filter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PlantsGuardApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PlantsGuardApplication.class, args);
	}

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(PlantsGuardApplication.class);
    }
//
//	@Bean
//	  public Filter TracingFilter() {
//	    return new AWSXRayServletFilter("plantsguard-keeper");
//	  }
//    
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("*");
//            }
//        };
//    }
}
