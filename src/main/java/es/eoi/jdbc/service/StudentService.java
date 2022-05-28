package es.eoi.jdbc.service;

import es.eoi.jdbc.entity.Student;
import es.eoi.jdbc.repository.StudentRepository;

import java.util.List;

public class StudentService implements StudentRepository {
    //Constructor


    public StudentService() {

    }

    //Metodos
    public Student findById(String id) {
        return null;
    }

    public List<Student> findAll() {
        return null;
    }

    public Student create() {
        return null;
    }

    public boolean delete(String id) {
        return false;
    }

    public Student update() {
        return null;
    }
}
