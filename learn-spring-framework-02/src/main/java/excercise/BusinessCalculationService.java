package excercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan
public class BusinessCalculationService {

    DataService dataService;

    @Autowired
    public BusinessCalculationService(@Qualifier("mySQLDataService") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(@Qualifier("mySQLDataService") DataService dataService) {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            var dataService = context.getBean(DataService.class);
            System.out.println(context.getBean(BusinessCalculationService.class).findMax(dataService));
        }
    }
}
