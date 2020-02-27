package com.rissandimo.studentcms.controller;

import com.rissandimo.studentcms.dao.Student;
import com.rissandimo.studentcms.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Transient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest
{
    @Autowired
    private StudentRepository studentRepository;

    private Student student;

    @Before
    public void createStudent()
    {
        student = new Student("John", "Doe");
    }

    @Transient
    @Test
    public void createStudentTest()
    {
        Student newStudent = studentRepository.save(student);

        Student john = studentRepository.findStudentByStudentNumber(1);
        Assert.assertTrue(newStudent.equals(john));
    }
}
