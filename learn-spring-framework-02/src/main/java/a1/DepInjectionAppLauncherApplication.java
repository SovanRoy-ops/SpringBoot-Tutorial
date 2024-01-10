package a1;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {
    @Autowired
    Dependency1 dependency1; // Field Injection
    @Autowired
    Dependency2 dependency2; // Field Injection

    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {  // Constructor Injection
        // Best part about constructor injection is that you that have to mention @Autowired. Spring automatically applies dependencies during Constructor injection
        // Spring team recommends to using Constructor based injection as dependencies are automatically set when an object is created
        System.out.println("Using Constructor injection !!");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Autowired
    public void setDependency1(Dependency1 dependency1) {  // Setter Injection
        System.out.println("Using Setter injection s1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {  // Setter Injection
        System.out.println("Using Setter injection s2");
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan
public class DepInjectionAppLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DepInjectionAppLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
