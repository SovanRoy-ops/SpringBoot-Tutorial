package f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    // After Spring has autowired the dependencies, if we want to execute some initialisation logic like fetch something from db ,etc then use @PostConstruct
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    // Before a bean instance is removed or destroyed if we want perform some actions like cleanup then we can use @PreDestroy
    @PreDestroy
    public void cleanUp() {
        System.out.println("Cleaning Up");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic using some dependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
