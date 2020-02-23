package com.rissandimo.studentcms.dao;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends SchoolPersonnel
{

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courseList = new HashSet<>();

    public Set<Course> getCourseList()
    {
        return courseList;
    }

    public void addCourse(Course newCourse)
    {
        this.courseList.add(newCourse);
    }
}
