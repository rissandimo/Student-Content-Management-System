package com.rissandimo.studentcms.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course extends BaseEntity<Long>
{
    private int id;
    private String name;
    private int currentNumberOfStudents;
    private int maxNumOfStudents;

    public Course()
    {
    }

    public Course(String name, int maxNumOfStudents)
    {
        this.name = name;
        this.maxNumOfStudents = maxNumOfStudents;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable
            (
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
            )
    private Set<Student> enrolledStudents = new HashSet<>();


    public Set<Student> getEnrolledStudents()
    {
        return enrolledStudents;
    }

    public boolean addStudent(Student newStudent)
    {
        if(maxNumOfStudents < currentNumberOfStudents)
        {
            this.enrolledStudents.add(newStudent);
            newStudent.addCourse(this);
            currentNumberOfStudents++;
            return true;
        }
        return false;
    }

}
