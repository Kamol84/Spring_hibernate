package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.AuthorConverter;
import pl.coderslab.converter.LocalDateConverter;
import pl.coderslab.converter.PublisherConverter;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(publisherConverter());
        registry.addConverter(authorConverter());
        registry.addConverter(localDateConverter());

    }

    @Bean
    public PublisherConverter publisherConverter(){
        return new PublisherConverter();
    }

    @Bean
    public AuthorConverter authorConverter(){
        return new AuthorConverter();
    }

    @Bean
    public LocalDateConverter localDateConverter(){
        return new LocalDateConverter();
    }
}
