package org.example.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:pathToFile.properties")
@EnableAspectJAutoProxy
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
