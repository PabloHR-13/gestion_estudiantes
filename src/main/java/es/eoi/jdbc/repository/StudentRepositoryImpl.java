package es.eoi.jdbc.repository;

import es.eoi.jdbc.StudentManagementMain;
import es.eoi.jdbc.entity.Student;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


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
            String querystudent = "delete from student where id="+id+";";

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
        String dato="";
        String todo="";
        String querystudent="";
        while(!dato.equals("0")) {
            System.out.println("Aspectos a modificar: ");
            System.out.println("-------------------------");
            System.out.println("1 - nombre: ");
            System.out.println("2 - apellido: ");
            System.out.println("3 - cumple: ");
            System.out.println("0 - salir");
            System.out.println("-------------------------");

            //Escaner
            Scanner mientrada = new Scanner(System.in);
            System.out.println("Que desea hacer: ");
            dato = mientrada.nextLine();

            try {
                Statement st = StudentManagementMain.cn.createStatement();

                switch (dato) {
                    case "0":
                        System.out.println("Hasta la proxima modificacion");
                        break;
                    case "1":
                        System.out.println("Que NOMBRE desea establecer: ");
                        todo=mientrada.nextLine();
                        querystudent = "update student set name='"+todo+"' where id="+student.getId()+";";
                        st.executeUpdate(querystudent);
                        break;
                    case "2":
                        System.out.println("Que APELLIDO desea establecer: ");
                        todo=mientrada.nextLine();
                        querystudent = "update student set surname='"+todo+"' where id="+student.getId()+";";
                        st.executeUpdate(querystudent);
                        break;
                    case "3":
                        System.out.println("Que CUMPLE desea establecer: ");
                        todo=mientrada.nextLine();
                        querystudent = "update student set birth_date='"+todo+"' where id="+student.getId()+";";
                        st.executeUpdate(querystudent);
                        break;
                    default:
                        System.out.println("el numero introducido no esta entre 1 y 3");
                        break;
                }
            }catch (SQLException e){
                e.fillInStackTrace();
            }
        }


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
