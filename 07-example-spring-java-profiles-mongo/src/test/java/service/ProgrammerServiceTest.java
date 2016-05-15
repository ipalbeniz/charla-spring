package service;

import config.SpringContextConfig;
import dao.ProgrammerDao;
import model.Programmer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = SpringContextConfig.class)
@ActiveProfiles("dev")
public class ProgrammerServiceTest {

    @Autowired
    ProgrammerService programmerService;

    @Test
    public void testGetById() {

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals(getExpectedProgrammer(), programmer);
    }

    private Programmer getExpectedProgrammer() {
        return new Programmer("iperez", "Íñigo Montoya", 45);
    }

}