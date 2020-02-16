package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Student extends SchoolPersonnel
{
    @OneToMany
    private List<Course> courseList;
}
