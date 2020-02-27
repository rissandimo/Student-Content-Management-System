package com.rissandimo.studentcms.SchoolInitializer;

import com.rissandimo.studentcms.dao.Student;
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

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception
    {
        //create and save student
        Student student = new Student("John", "Smith");
        studentRepository.save(student);
        logger.info("Student: " + student);
    }
}
