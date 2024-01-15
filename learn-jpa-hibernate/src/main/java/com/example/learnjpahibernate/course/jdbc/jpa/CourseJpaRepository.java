package com.example.learnjpahibernate.course.jdbc.jpa;

import com.example.learnjpahibernate.course.jdbc.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional // -> used when we want to do transactions with entitymanager
public class CourseJpaRepository {

    // @Autowired
    @PersistenceContext // <-- More specific annotation for entitymanager(used in place of @Autowired
            EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        var course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
