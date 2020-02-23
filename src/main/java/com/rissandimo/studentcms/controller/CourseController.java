package com.rissandimo.studentcms.controller;

import com.rissandimo.studentcms.dao.Course;
import com.rissandimo.studentcms.exceptions.CourseNotFoundException;
import com.rissandimo.studentcms.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController
{
    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping("/courses")
    public List<Course> retrieveCourses()
    {
        return coursesRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course retrieveCourseById(@PathVariable("id") int id)
    {
        Optional<Course> courseOptional = coursesRepository.findById(id);
        if(courseOptional.isPresent())
            return courseOptional.get();
        else throw new CourseNotFoundException("Course with id: " + id + " not found");
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course)
    {
        return coursesRepository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourseById(@PathVariable("id") int id)
    {
        coursesRepository.deleteById(id);
    }
}
