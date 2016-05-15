package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SpringMvcContextConfig {

    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

}
