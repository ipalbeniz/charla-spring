package service;

import model.Programmer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProgrammerServiceTest {

    @Autowired
    ProgrammerService programmerService;

    @Test
    public void testGetById() {

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals(getExpectedProgrammer(), programmer);
    }

    private Programmer getExpectedProgrammer() {
        return new Programmer("iperez", "Iñaki", 34);
    }

}