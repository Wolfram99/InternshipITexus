package org.example.booksapp.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Locale;

@Configuration
@PropertySource("classpath:pathToFile.properties")
@EnableAspectJAutoProxy
@EnableWebMvc
public class SpringConfig {

    @Bean
    public MessageSource messageSource(){
        var source = new ReloadableResourceBundleMessageSource();
        source.setBasename("messageSources/messages");
        source.setDefaultEncoding("windows-1251");
        source.setDefaultLocale(Locale.forLanguageTag("EN"));
        return source;
    }
}
