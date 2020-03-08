package com.rissandimo.studentcms.repository;

import com.rissandimo.studentcms.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
    Student findStudentByStudentNumber(int studentNumber);
}
