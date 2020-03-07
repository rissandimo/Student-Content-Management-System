package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Instructor extends SchoolPersonnel
{
    @OneToMany
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String firstName, String latName)
    {
        super(firstName, latName);
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }

    public void addCourseTaught(Course newCourse)
    {
        this.courseList.add(newCourse);
    }

    // view students enrolled in classes
}
