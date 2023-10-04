package com.cg.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


@Configuration
@EnableWebSecurity // It indicates that a class is a configuration class responsible for configuring Spring Security in your application
public class ConfigSecurity {
	@Bean(name = "definingrole")
	public UserDetailsService userService() {
		UserDetails admin=User.withUsername("janvi").password(passwordEncoder().encode("janvi")).roles("ADMIN").build();
		UserDetails normalUser=User.withUsername("root").password(passwordEncoder().encode("root")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin,normalUser);
	}
@Bean	
public PasswordEncoder passwordEncoder () {
	return new BCryptPasswordEncoder();
	
	}

@Bean(name = "mysecurity")
public SecurityFilterChain filter(HttpSecurity http)throws Exception{
	http.csrf((csrf)->csrf.disable()).authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/v1/**").hasRole("ADMIN").anyRequest().authenticated())
	        .formLogin(formLogin -> formLogin.permitAll());
	
	return http.build();
}


//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userService())
//        .passwordEncoder(passwordEncoder());
//}



	
}
