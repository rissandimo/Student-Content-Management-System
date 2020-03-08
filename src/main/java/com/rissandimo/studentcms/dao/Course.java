package com.rissandimo.studentcms.dao;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})

    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> enrolledStudents = new HashSet<>();


    public Set<Student> getEnrolledStudents()
    {
        return enrolledStudents;
    }

    public void addStudent(Student newStudent)
    {
        if(currentNumberOfStudents < maxNumOfStudents)
        {
            enrolledStudents.add(newStudent);
            newStudent.addCourse(this);
            currentNumberOfStudents++;
        }
    }

    public boolean removeStudent(Student studentToUnregister)
    {
        enrolledStudents.remove(studentToUnregister);
        currentNumberOfStudents--;
        return true;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
