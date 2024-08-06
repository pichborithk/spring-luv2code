package dev.pichborith.cruddemo;

import dev.pichborith.cruddemo.dao.AppDAO;
import dev.pichborith.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
//            createInstructor(appDAO);

//			findInstructor(appDAO);

//            deleteInstructor(appDAO);

//            findInstructorDetail(appDAO);

//            deleteInstructorDetail(appDAO);

//            createInstructorWithCourses(appDAO);

            findInstructorWithCourses(appDAO);

//            findInstructorWithCoursesJoinFetch(appDAO);

//            updateInstructor(appDAO);

//            updateCourse(appDAO);

//            deleteCourse(appDAO);

//            createCourseAndReviews(appDAO);

//            retrieveCourseAndReviews(appDAO);

//            deleteCourseAndReviews(appDAO);

//            createCourseAndStudents(appDAO);

//            findCourseAndStudents(appDAO);

//            findStudentAndCourses(appDAO);

//            addMoreCoursesForStudent(appDAO);

//            deleteStudent(appDAO);
        };

    }

    private void createInstructor(AppDAO appDAO) {
        // create instructor
        Instructor tempInstructor = new Instructor("Chad", "Darby",
                                                   "darby@luv2code.com");

        // create instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
            "http://www.luv2code.com/youtube", "Coding");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // NOT: this will also save the instructor detail because of cascade
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor detail id: " + theId);

        InstructorDetail tempInstructorDetail = appDAO.findInstactorDetailById(
            theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        System.out.println(
            "the associated instructor: " + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create instructor
        Instructor tempInstructor = new Instructor("Susan", "Public",
                                                   "susan.public@luv2code.com");

        // create instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
            "http://www.youtube.com", "Gaming");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Air Guitar");
        Course tempCourse2 = new Course("Pinball");
        Course tempCourse3 = new Course("Java");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        // save the instructor
        // NOT: this will also save the instructor detail and courses because of cascade persist
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        tempInstructor.setCourses(courses);

        // this line going to throw exception, because the default fetch type of OneToMany is "Lazy"
        // so Hibernate didn't load any course from database yet.
        // fix it by get course with method above
        System.out.println(
            "the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 2;

        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println(
            "the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {

        int theId = 2;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("TESTER");

        appDAO.update(tempInstructor);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course tempCourse = new Course(
            "Pacman - How to Score One Million Points");

        tempCourse.addReview(new Review("Great course... loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        System.out.println("Saving Course: " + tempCourse);
        appDAO.save(tempCourse);

        System.out.println("Done!");

    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int theId = 10;

        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done");
    }

    private void createCourseAndStudents(AppDAO appDAO) {

        // create a course
        Course tempCourse = new Course("DevOps Master");

        // caste the students
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

        // add students to course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        // save the course and associated students
        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

        appDAO.save(tempCourse);

        System.out.println("Done");
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int theId = 11;

        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("Done");
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int theId = 2;

        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        System.out.println("Loaded student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());

        System.out.println("Done");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int theId = 2;

        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Rubik's Cub - How to Speed Cube");
        Course tempCourse2 = new Course("Game Development");

        // add courses to student
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Updating student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());

        appDAO.update(tempStudent);

        System.out.println("Done");
    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Deleting student id: " + theId);

        appDAO.deleteStudentById(theId);

        System.out.println("Done");
    }
}
