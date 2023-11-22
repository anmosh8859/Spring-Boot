package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    EntityManager manager;
    public void insert(Course course){
        manager.merge(course);
    }

    public Course findById(long  id){
        return manager.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course = manager.find(Course.class, id);
        manager.remove(course);
    }
}
