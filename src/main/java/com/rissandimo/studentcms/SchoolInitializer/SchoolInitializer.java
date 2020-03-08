package com.rissandimo.studentcms.SchoolInitializer;

import com.rissandimo.studentcms.dao.Course;
import com.rissandimo.studentcms.dao.Student;
import com.rissandimo.studentcms.repository.CoursesRepository;
import com.rissandimo.studentcms.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class SchoolInitializer implements CommandLineRunner
{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception
    {
        //create and save student
        Student student = new Student("John", "Smith");
        studentRepository.save(student);
        logger.info("Student: " + student);

        // create and save course
        Course course = new Course("History", 25);
        coursesRepository.save(course);

       //bind student with course
        course.addStudent(student);

        logger.info("student: " + student);

        //update student and course
        coursesRepository.save(course);


    }
}
