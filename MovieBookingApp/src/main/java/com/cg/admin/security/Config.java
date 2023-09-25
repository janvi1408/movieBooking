package com.cg.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // It indicates that a class is a configuration class responsible for configuring Spring Security in your application
public class Config {
	@Bean
	public UserDetailsService userService() {
		UserDetails admin=User.withUsername("janvi").password(passwordEncoder().encode("janvi")).roles("ADMIN").build();
		UserDetails normalUser=User.withUsername("root").password(passwordEncoder().encode("root")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin,normalUser);
	}
@Bean	
public PasswordEncoder passwordEncoder () {
	return new BCryptPasswordEncoder();
	
	}

@Bean
public SecurityFilterChain filter(HttpSecurity http)throws Exception{
	http.csrf((csrf)->csrf.disable()).authorizeHttpRequests(authorize -> authorize
			.requestMatchers("city/**").hasRole("ADMIN").anyRequest().authenticated())
	        .formLogin(formLogin -> formLogin.permitAll());
	return http.build();
}




	
}
