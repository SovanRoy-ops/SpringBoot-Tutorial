package com.example.learnjpahibernate.course.jdbc;

import com.example.learnjpahibernate.course.jdbc.jpa.CourseJpaRepository;
import com.example.learnjpahibernate.course.jdbc.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "AZURE", "Tim learner"));
//        repository.insert(new Course(2, "AWS", "BEN learner"));
//        repository.insert(new Course(3, "ZEN", "KEN learner"));
//        repository.insert(new Course(4, "YURI", "REVEN learner"));

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "AZURE", "Tim learner"));
        repository.save(new Course(2, "AWS", "BEN learner"));
        repository.save(new Course(3, "ZEN", "KEN learner"));
        repository.save(new Course(4, "YURI", "REVEN learner"));


        repository.deleteById(2L);

        System.out.println(repository.findById(4L));
        System.out.println(repository.findById(1L));
    }
}
