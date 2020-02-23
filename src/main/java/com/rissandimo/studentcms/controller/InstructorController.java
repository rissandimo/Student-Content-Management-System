package com.rissandimo.studentcms.controller;

import com.rissandimo.studentcms.dao.Instructor;
import com.rissandimo.studentcms.exceptions.InstructorNotFoundException;
import com.rissandimo.studentcms.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
public class InstructorController
{
    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/instructors")
    public List<Instructor> retrieveInstructors()
    {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public Instructor retrieveInstructorById(@PathVariable("id") int id)
    {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if(instructorOptional.isPresent())
            return instructorOptional.get();
        else throw new InstructorNotFoundException("Instructor with id: " + id + " is not found");
    }

    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor)
    {
        return instructorRepository.save(instructor);
    }

    @DeleteMapping("/instuctors/{id}")
    public void deleteInstructorById(@PathVariable("id") int id)
    {
        instructorRepository.deleteById(id);
    }
}
