package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Instructor extends SchoolPersonnel
{
    private List<Courses> coursesList;
}
