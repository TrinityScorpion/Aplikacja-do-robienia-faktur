package com.example;

import com.example.recipient.RecipientConverter;
import com.example.sender.SenderConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.Validator;
import java.util.Locale;

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
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public RecipientConverter getRecipientConverter() {
        return new RecipientConverter();
    }

    @Bean
    public SenderConverter getSenderConverter() {
        return new SenderConverter();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }
}
