package com.izzat.university.service;

import com.izzat.university.dto.CreateModule;
import com.izzat.university.dto.CreateStudent;
import com.izzat.university.dto.CreateEnrolment;
import com.izzat.university.entity.Enrolment;
import com.izzat.university.entity.Module;
import com.izzat.university.entity.Student;
import com.izzat.university.repository.EnrolmentRepository;
import com.izzat.university.repository.ModuleRepository;
import com.izzat.university.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@Transactional
public class StudentModuleService {
    private final StudentRepository studentRepository;
    private final ModuleRepository moduleRepository;
    private final EnrolmentRepository enrolmentRepository;

    @Autowired
    public StudentModuleService(StudentRepository studentRepository, ModuleRepository moduleRepository, EnrolmentRepository enrolmentRepository) {
        this.studentRepository = studentRepository;
        this.moduleRepository = moduleRepository;
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Student> getListOfStudentByModuleId(String moduleId) {
        try{
        List<String> listOfStudentByModuleId = getEnrolmentByModuleId(moduleId).stream().map(Enrolment::getStudentId).collect(Collectors.toList());
        return studentRepository.findAllById(listOfStudentByModuleId);
        } catch (Exception e) {
            log.catching(e);
        }
        return null;
    }

    public List<Module> getListOfModuleByStudentId(String studentId) {
        try{
        List<String> listOfModulesId = getEnrolmentByStudentId(studentId).stream().map(Enrolment::getModuleId).collect(Collectors.toList());
        return moduleRepository.findAllById(listOfModulesId);
        }catch (Exception e){
            log.catching(e);
        }
        return null;
    }

    public List<Enrolment> getEnrolmentByModuleId(String moduleId) {
        return enrolmentRepository.findAllByModuleId(moduleId);
    }

    public List<Enrolment> getEnrolmentByStudentId(String studentId) {
        try{
        return enrolmentRepository.findAllByStudentId(studentId);
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public Enrolment addEnrolment(CreateEnrolment createEnrolment) {
        try{
        Enrolment e = new Enrolment();
        e.setModuleId(createEnrolment.getModuleId());
        e.setStudentId(createEnrolment.getStudentId());
        return enrolmentRepository.save(e);
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public Student getStudentById(String id) {
        try{
        return studentRepository.findById(id).orElse(null);
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public List<Student> getStudentByName(String name) {
        try{
        return studentRepository.findAllByFirstNameContainingOrLastNameContaining(name, name);
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public List<Student> getAllStudents() {
        try{
        return studentRepository.findAll();
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public Student addNewStudent(CreateStudent student) {
        try{
        Student s = new Student();
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        return studentRepository.save(s);
        } catch (Exception e){
            log.catching(e);
        }
        return null;
    }
//
//    public List<Student> findAllbyModuleId(int i){
//        return studentRepository.findAllByModulesId(i);
//    }


    /**
     * ********************************************************************************************************************
     */

    public Module getModuleById(String id) {
        try{
        return moduleRepository.findById(id).orElse(null);
            }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public List<Module> getAllModules() {
        try{
        return moduleRepository.findAll();
        }catch(Exception e){
            log.catching(e);
        }
        return null;
    }

    public List<Module> getModuleByName(String name) {
        try{ 
        return moduleRepository.findAllByModuleNameContaining(name);
        }catch (Exception e){
            log.catching(e);
        }
        return null;
    }

    public Module addNewModule(CreateModule module) {
        try{
        Module m = new Module();
        m.setModuleName(module.getModuleName());
        m.setModuleDetails(module.getModuleDetails());
        return moduleRepository.save(m);
        }catch(Exception e) {
            log.catching(e);
        }
        return null;
    }
}
