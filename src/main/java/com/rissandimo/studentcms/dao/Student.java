package com.rissandimo.studentcms.dao;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends SchoolPersonnel
{

    public Student ()
    {

    }

    public Student(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    private int studentNumber;

    public int getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber)
    {
        this.studentNumber = studentNumber;
    }


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH},
    fetch = FetchType.EAGER)
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

    @Override
    public String toString()
    {
        return getFirstName() + " " + getLastName() + " " + getCourseList();
    }
}
