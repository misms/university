package com.izzat.university.repository;

import com.izzat.university.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {
    List<Module> findAllByModuleNameContaining(String name);
}
