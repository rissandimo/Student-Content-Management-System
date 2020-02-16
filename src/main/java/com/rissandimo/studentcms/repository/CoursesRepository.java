package com.rissandimo.studentcms.repository;

import com.rissandimo.studentcms.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Integer>
{
}
