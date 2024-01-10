package com.example.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        //1: Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) { // try with resourcing will automatically close the context and handle any memory leak exceptions if found

            //2: Configure the things that we want Spring to manage -
            //HelloWorldConfiguration - @Configuration
            //name - @Bean

            //3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("Ravi"));
            System.out.println(context.getBean("Sovan"));
            // get bean by name
            System.out.println(context.getBean("address2"));
            // get bean by type class
            System.out.println(context.getBean(HelloWorldConfiguration.Person.class));

            System.out.println(context.getBean(HelloWorldConfiguration.Address.class));
        }

        // list all the beans
      //  Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
