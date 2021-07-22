package com.example;

import com.example.recipient.RecipientConverter;
import com.example.sender.SenderConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CodersLabLastProjectApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CodersLabLastProjectApplication.class, args);

	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getRecipientConverter());
		registry.addConverter(getSenderConverter());

	}

	@Bean
	public RecipientConverter getRecipientConverter() {
		return new RecipientConverter();
	}

	@Bean
	public SenderConverter getSenderConverter(){
		return new SenderConverter();
	}
}
