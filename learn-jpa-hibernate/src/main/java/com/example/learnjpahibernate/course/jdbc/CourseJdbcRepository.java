package com.example.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = """
                    insert into course ( id , name , author )
                    values(?,?,?);
            """;

    private static String DELETE_QUERY = """
                    delete from course where id=?;
            """;

    private static String SELECT_QUERY = """
                    select * from course where id=?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long courseId) {
        springJdbcTemplate.update(DELETE_QUERY, courseId);
    }

    public Course findById(Long courseId) {
        // queryForObject provides us with a result set and we need to then map with the Row Mapper property of bean of the targeted class
        // ResultSet -> Bean => Row Mapper =>
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), courseId);
    }
}
