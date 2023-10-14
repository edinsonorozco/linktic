package co.com.linktic.ws.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${controller.properties.base-path}")
	private String uriBasePattern;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		String uriPattern = "/" + this.uriBasePattern + "/**";
		
		httpSecurity.headers().xssProtection().and().contentSecurityPolicy("script-src 'self'");
		httpSecurity.csrf()
	     .ignoringAntMatchers(uriPattern)
	     .and()
	     .authorizeRequests()
	     .antMatchers(uriPattern).permitAll();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));

		configuration.addAllowedHeader("Content-Type");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
}
