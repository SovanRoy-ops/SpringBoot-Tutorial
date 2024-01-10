package com.example.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {

    //Eliminate verbosity in creating Java Beans   --> Records
    //Public accessor methods, constructor,
    //equals, hashcode and toString are automatically created.
    //Released in JDK 16.
    record Person(String name, int age, Address address) {
    }

    //Address - firstLine & city
    record Address(String firstLine, String city) {
    }


    @Bean
    public String name() {
        return "Sovan";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean(name = "Ravi")
    @Primary
    public Person person() {
        return new Person("Ravi", 20, new Address("Main St", "NYC"));
    }

    @Bean(name = "Sovan") // Bean which is taking values from other beans using method calls
    public Person person2MethodCall() {
        return new Person(name(), age(), address2());
    }

    @Bean(name = "Sovan3") // Bean which is taking values from other beans using parameters passed
    // @Qualifier is used to specify which bean should be passed as parameter when the name of the bean is not clearly specified or matching
    public Person person3Parameters(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("THAT Street", "UC");
    }

    @Bean(name = "address2")
    @Primary
    public Address address2() {
        return new Address("Baker Street", "London");
    }
}

