package com.rissandimo.studentcms.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorColumn(name = "personnel_type")
class SchoolPersonnel extends BaseEntity<Long>
{
     SchoolPersonnel()
    {

    }

    SchoolPersonnel(String firstName, String lastName)
    {
        super(firstName, lastName);
    }
}
