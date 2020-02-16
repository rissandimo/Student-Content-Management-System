package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Courses
{
    private int id;
    private String name;
    private int maxNumOfStudents;

    private List<Student> enrolledStudents;
}
