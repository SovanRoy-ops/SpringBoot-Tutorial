package com.example.learnjpahibernate.course.jdbc.springdatajpa;

import com.example.learnjpahibernate.course.jdbc.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
