package es.eoi.jdbc.repository;

import es.eoi.jdbc.StudentManagementMain;
import es.eoi.jdbc.entity.Student;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentRepositoryImpl implements StudentRepository{

    @Override
    public Student findById(int id) {

        Student student = null;
        try{
            Statement st = StudentManagementMain.cn.createStatement();
            String querystudent = "select * from student where id="+id+";";

            final ResultSet resultSet = st.executeQuery(querystudent);
            if (resultSet.next()){
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birth_date")
                );
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }



        return student;
    }

    @Override
    public void findAll() {
        try{
        Statement st = StudentManagementMain.cn.createStatement();
        String querystudent = "select * from student";


        final ResultSet resultSet = st.executeQuery(querystudent);
            while (resultSet.next()) {

                System.out.println(String.format("ID: %d", resultSet.getInt("id")));
                System.out.println(String.format("Nombre: %s", resultSet.getString("name")));
                System.out.println(String.format("Apellido: %s", resultSet.getString("surname")));
                System.out.println(String.format("Cumple: %s", resultSet.getString("birth_date")));
                System.out.println();

            }


        }catch (SQLException e){
            e.fillInStackTrace();
        }

    }

    @Override
    public Student create(int id,String nombre, String apellido, String cumple) {
        Student miAlumno = new Student(id,nombre,apellido,cumple);
        return miAlumno;
    }

    @Override
    public boolean delete(String id) {
            try{
            Statement st = StudentManagementMain.cn.createStatement();
            String querystudent = "delete * from student where id="+id+";";

            st.executeUpdate(querystudent);
            System.out.println("El alumno con id: " + id + " ha sido eliminado");
            return true;

        }catch (SQLException e){
            e.fillInStackTrace();
            System.out.println("El alumno no existe");
            return false;

        }

    }

    @Override
    public Student update(Student student) {






        return null;
    }

    @Override
    public void insert(Student student) {
        try{
            Statement st = StudentManagementMain.cn.createStatement();
            String insertstudent = "insert into student(id,name,surname,birth_date) values ("+student.getId()+", '"+ student.getName()+"', '"+student.getSurname()+"', '"+student.getBirth_date()+"');";
            st.executeUpdate(insertstudent);
        }catch (SQLException e){
            e.fillInStackTrace();
        }


    }


}
