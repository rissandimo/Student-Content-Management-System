package com.rissandimo.studentcms.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int currentNumberOfStudents;
    private int maxNumOfStudents;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Course()
    {
    }

    public Course(String name, int maxNumOfStudents)
    {
        this.name = name;
        this.maxNumOfStudents = maxNumOfStudents;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
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

    public boolean removeStudent(Student studentToUnregister)
    {
        enrolledStudents.remove(studentToUnregister);
        studentToUnregister.removeCourse(this);
        currentNumberOfStudents--;
        return true;
    }
}
