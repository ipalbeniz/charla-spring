package service;

import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import model.Programmer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ProgrammerServiceTest {

    @Test
    public void testGetById() {

        ProgrammerDao programmerDao = Mockito.mock(ProgrammerDao.class);
        Mockito.when(programmerDao.getById("iperez")).thenReturn(getExpectedProgrammer());

        ProgrammerService programmerService = new ProgrammerServiceImpl(programmerDao);

        Programmer programmer = programmerService.getById("iperez");

        Assert.assertEquals(getExpectedProgrammer(), programmer);
    }

    private Programmer getExpectedProgrammer() {
        return new Programmer("iperez", "Iñaki", 34);
    }

}