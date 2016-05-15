package service;

import dao.ProgrammerDao;
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
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = ProgrammerServiceAlternativeTestContextConfiguration.class)
public class ProgrammerServiceAlternativeTest {

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