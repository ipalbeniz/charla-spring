package service;

import model.Programmer;
import org.junit.Assert;
import org.junit.Test;

public class ProgrammerServiceTest {

    @Test
    public void it_should_get_a_programmer_by_id() {

        ProgrammerService programmerService = new ProgrammerServiceImpl();

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals("Iñaki", programmer.getName());
    }

}