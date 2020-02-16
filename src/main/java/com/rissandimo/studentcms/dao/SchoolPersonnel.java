package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SchoolPersonnel extends BaseEntity<Long>
{
    private String firstName;
    private String lastName;
}
