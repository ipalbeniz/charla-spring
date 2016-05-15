import config.SpringContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ProgrammerService;

public class DemoApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        ProgrammerService programmerService = (ProgrammerService) context.getBean("programmerService");

        System.out.println(String.format("%s loves %s",
                programmerService.getById("lcroft").getName(),
                programmerService.getById("iperez").getName()));
    }
}
