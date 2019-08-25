package com.izzat.university.repository;

import com.izzat.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
