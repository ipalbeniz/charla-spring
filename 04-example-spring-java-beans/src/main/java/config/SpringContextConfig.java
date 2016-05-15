package config;

import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ProgrammerService;
import service.ProgrammerServiceImpl;

@Configuration
public class SpringContextConfig {

    @Bean
    public ProgrammerDao programmerDao() {
        return new ProgrammerDaoMap();
    }

    @Bean
    public ProgrammerService programmerService() {
        return new ProgrammerServiceImpl(programmerDao());
    }
}
