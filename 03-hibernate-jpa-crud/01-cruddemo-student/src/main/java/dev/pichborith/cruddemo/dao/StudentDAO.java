package dev.pichborith.cruddemo.dao;

import dev.pichborith.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
