package co.com.linktic.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan
@SpringBootApplication
@EnableCircuitBreaker
/** 
 * 
 * Clase iniciadora de una aplicación Spring Boot
 * @version 1.0.0
 * @author Edinson Orozco González
 * 
 */
public class ApplicationProducto extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		
		 builder.up()
         .withDetail("app", "App ws")
         .withDetail("sucess", "OK");
		 
	}	
	
	/**
	 * Metodo principal, corre aplicación en Spring Boot
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProducto.class, args);
	}	
}
