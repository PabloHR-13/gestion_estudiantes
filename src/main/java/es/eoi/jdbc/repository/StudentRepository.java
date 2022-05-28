package es.eoi.jdbc.repository;

import es.eoi.jdbc.entity.Student;

import java.util.List;

public interface StudentRepository {
    public Student findById(String id);
    public List<Student> findAll();
    public Student create();
    public boolean delete(String id);
    public Student update();



}
