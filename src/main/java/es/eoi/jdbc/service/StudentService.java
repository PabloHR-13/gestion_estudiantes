package es.eoi.jdbc.service;

import es.eoi.jdbc.entity.Student;
import es.eoi.jdbc.repository.StudentRepository;



public class StudentService implements StudentRepository {

    private final StudentRepository repository;




    //Constructor
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    //Metodos
    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void findAll() {

    }

    @Override
    public Student create(int id, String nombre, String apellido, String cumple) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void insert(Student student) {

    }


}
