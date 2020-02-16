package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course extends BaseEntity<Long>
{
    private int id;
    private String name;
    private int maxNumOfStudents;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "student")
    private List<Student> enrolledStudents;
}
