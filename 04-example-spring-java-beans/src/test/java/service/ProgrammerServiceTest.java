package service;

import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import model.Programmer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ProgrammerServiceTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public ProgrammerDao programmerDao() {
            return Mockito.mock(ProgrammerDao.class);
        }

        @Bean
        public ProgrammerService programmerService() {
            return new ProgrammerServiceImpl(programmerDao());
        }
    }

    @Autowired
    ProgrammerService programmerService;

    @Autowired
    ProgrammerDao programmerDao;

    @Test
    public void testGetById() {

        Mockito.when(programmerDao.getById("iperez")).thenReturn(getExpectedProgrammer());
        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals(getExpectedProgrammer(), programmer);
    }

    private Programmer getExpectedProgrammer() {
        return new Programmer("iperez", "Iñaki", 34);
    }

}