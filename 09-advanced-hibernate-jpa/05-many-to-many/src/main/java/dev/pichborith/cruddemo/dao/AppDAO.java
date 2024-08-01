package dev.pichborith.cruddemo.dao;

import dev.pichborith.cruddemo.entity.Course;
import dev.pichborith.cruddemo.entity.Instructor;
import dev.pichborith.cruddemo.entity.InstructorDetail;
import dev.pichborith.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstactorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    Course findCourseById(int theId);

    void update(Course tempCourse);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student tempStudent);

    void deleteStudentById(int theid);
}
