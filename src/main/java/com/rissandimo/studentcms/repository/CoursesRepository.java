package com.rissandimo.studentcms.repository;

import com.rissandimo.studentcms.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Integer>
{
    //find courses by a student id
}
