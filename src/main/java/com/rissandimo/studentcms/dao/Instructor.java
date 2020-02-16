package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Instructor extends SchoolPersonnel
{
    @OneToMany
    private List<Course> courseList;
}
