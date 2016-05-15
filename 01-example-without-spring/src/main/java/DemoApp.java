import service.ProgrammerService;
import service.ProgrammerServiceImpl;

public class DemoApp {

    public static void main(String[] args) {

        ProgrammerService programmerService = new ProgrammerServiceImpl();

        System.out.println(String.format("%s loves %s",
                programmerService.getById("lcroft").getName(),
                programmerService.getById("iperez").getName()));
    }
}
