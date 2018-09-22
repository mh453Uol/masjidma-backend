package com.mh453Uol.masjidma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mh453Uol.masjidma.filters.CorsFilter;

@SpringBootApplication
public class MasjidmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasjidmaApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
		FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter());

		registrationBean.setName("Cors Filter");
		registrationBean.addUrlPatterns("/*"); // executes for all requests
		registrationBean.setOrder(1);

		return registrationBean;
	}

	@Bean
	public JavaTimeModule dateTimeModule() {
		return new JavaTimeModule();
	}

}
