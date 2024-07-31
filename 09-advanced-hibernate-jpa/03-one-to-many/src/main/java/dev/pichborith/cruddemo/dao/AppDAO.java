package dev.pichborith.cruddemo.dao;

import dev.pichborith.cruddemo.entity.Course;
import dev.pichborith.cruddemo.entity.Instructor;
import dev.pichborith.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstactorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
