package es.eoi.jdbc.repository;

import es.eoi.jdbc.entity.Student;

import java.util.List;

public interface StudentRepository {
//    String repository;
    public Student findById(int id);
    public void findAll();
    public Student create(int id,String nombre, String apellido, String cumple);
    public boolean delete(String id);
    public Student update(Student student);
    public void insert(Student student);


}
