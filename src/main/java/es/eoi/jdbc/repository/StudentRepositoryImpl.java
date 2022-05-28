package es.eoi.jdbc.repository;

import es.eoi.jdbc.entity.Student;

import java.sql.Connection;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    Connection openConnection() {
        return null;
    }

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
