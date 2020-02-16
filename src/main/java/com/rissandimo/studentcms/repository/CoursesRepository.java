package com.rissandimo.studentcms.repository;

import com.rissandimo.studentcms.dao.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Integer>
{
}
