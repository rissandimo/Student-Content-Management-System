package com.rissandimo.studentcms.controller;

import com.rissandimo.studentcms.dao.Student;
import com.rissandimo.studentcms.exceptions.StudentNotFoundException;
import com.rissandimo.studentcms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> retrieveStudents()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent())
            return studentOptional.get();
        else throw new StudentNotFoundException("Student id: " + id + " not found");
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student)
    {
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable("id") int id)
    {
        studentRepository.deleteById(id);
    }

    // add method to view courses enrolled in
}
