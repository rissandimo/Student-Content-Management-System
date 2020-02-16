package com.rissandimo.studentcms.repository;

import com.rissandimo.studentcms.dao.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>
{
}
