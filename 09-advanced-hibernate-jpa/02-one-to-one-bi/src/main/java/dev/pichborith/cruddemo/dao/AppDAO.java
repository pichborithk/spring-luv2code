package dev.pichborith.cruddemo.dao;

import dev.pichborith.cruddemo.entity.Instructor;
import dev.pichborith.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstactorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
