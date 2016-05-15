package service;

import dao.ProgrammerDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgrammerServiceAlternativeTestContextConfiguration {

    @Bean
    public ProgrammerDao programmerDao() {
        return Mockito.mock(ProgrammerDao.class);
    }

    @Bean
    public ProgrammerService programmerService() {
        return new ProgrammerServiceImpl(programmerDao());
    }
}
