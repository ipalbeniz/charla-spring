package service;

import model.Programmer;
import org.junit.Assert;
import org.junit.Test;

public class ProgrammerServiceTest {

    @Test
    public void testGetById() {

        ProgrammerService programmerService = new ProgrammerServiceImpl();

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals("iperez", programmer.getId());
    }

}