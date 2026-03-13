package com.capgemini.EventManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails admin = User.builder()
				.username("admin")
				.password(encode().encode("admin123"))
				.roles("ADMIN")
				.build();

		UserDetails user = User.builder()
				.username("user")
				.password(encode().encode("user123"))
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(org.springframework.http.HttpMethod.GET, "/events/**")
						.hasAnyRole("USER", "ADMIN")
						.requestMatchers(org.springframework.http.HttpMethod.POST, "/events").hasRole("ADMIN")
						.requestMatchers(org.springframework.http.HttpMethod.PUT, "/events/**").hasRole("ADMIN")
						.requestMatchers(org.springframework.http.HttpMethod.PATCH, "/events/**").hasRole("ADMIN")
						.requestMatchers(org.springframework.http.HttpMethod.DELETE, "/events/**").hasRole("ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")

						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.build();
	}

}
