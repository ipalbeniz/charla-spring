package service;

import dao.ProgrammerDao;
import model.Programmer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ProgrammerServiceTest {

    @Test
    public void it_should_get_a_programmer_by_id() {

        ProgrammerDao programmerDao = Mockito.mock(ProgrammerDao.class);

        Programmer expectedProgrammer = new Programmer("iperez", "Iñaki", 34);
        Mockito.when(programmerDao.getById("iperez")).thenReturn(expectedProgrammer);

        ProgrammerService programmerService = new ProgrammerServiceImpl(programmerDao);

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals(expectedProgrammer, programmer);
    }

}