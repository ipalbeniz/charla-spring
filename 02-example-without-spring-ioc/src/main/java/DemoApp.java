import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import service.ProgrammerService;
import service.ProgrammerServiceImpl;

public class DemoApp {

    public static void main(String[] args) {

        ProgrammerDao programmerDao = new ProgrammerDaoMap();
        ProgrammerService programmerService = new ProgrammerServiceImpl(programmerDao);

        System.out.println(String.format("%s loves %s",
                programmerService.getById("lcroft").getName(),
                programmerService.getById("iperez").getName()));
    }
}
