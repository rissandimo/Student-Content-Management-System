package com.rissandimo.studentcms.dao;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Student extends SchoolPersonnel
{
    private long studentNumber;

    public Student()
    {

    }

    public Student(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

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


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(super.hashCode(), studentNumber);
    }

    public void setStudentNumber(Long id)
    {
        this.studentNumber = id;
    }

    @Override
    public String toString()
    {
        return this.getFirstName() + " " + this.getLastName() + " : " + this.getId();
    }
}
