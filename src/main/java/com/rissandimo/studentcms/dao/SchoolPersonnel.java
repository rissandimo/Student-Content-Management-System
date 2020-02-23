package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorColumn(name = "personnel_type")
public class SchoolPersonnel extends BaseEntity<Long>
{
    private String firstName;
    private String lastName;
}
