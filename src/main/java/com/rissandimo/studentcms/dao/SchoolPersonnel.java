package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "personnel_type")
class SchoolPersonnel extends BaseEntity
{
     SchoolPersonnel()
    {

    }

    SchoolPersonnel(String firstName, String lastName)
    {
        super(firstName, lastName);
    }
}
