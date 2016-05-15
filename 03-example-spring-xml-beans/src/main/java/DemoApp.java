import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ProgrammerService;

public class DemoApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProgrammerService programmerService = (ProgrammerService) context.getBean("programmerService");

        System.out.println(String.format("%s loves %s",
                programmerService.getById("lcroft").getName(),
                programmerService.getById("iperez").getName()));
    }
}
