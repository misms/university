package com.izzat.university.repository;

import com.izzat.university.entity.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment,String> {
    List<Enrolment> findAllByModuleId(String moduleId);
    List<Enrolment> findAllByStudentId(String studentId);

}
