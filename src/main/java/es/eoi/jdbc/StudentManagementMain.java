package es.eoi.jdbc;
import com.mysql.cj.jdbc.StatementImpl;
import es.eoi.jdbc.entity.Student;
import es.eoi.jdbc.repository.StudentRepository;
import es.eoi.jdbc.repository.StudentRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagementMain {
    public static Connection cn;

    public static void main(String[] args)throws SQLException{
        //Conexion bbdd
        final String url = "jdbc:mysql://127.0.0.1:3306/jdbcproject";
        final String user = "root";
        final String password = "1234";

       cn = DriverManager.getConnection(url, user, password);
        System.out.println(String.format("Already Connected to  %s", url));


        //Declaracion
        String dato= "";
        int id;
        String nombre;
        String apellido;
        String cumple;
        Student alumno = null;
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

        //Main
        while(!dato.equals("0")) {
            System.out.println("GESTION INSTITUTO V1");
            System.out.println("--------------------------");
            System.out.println("1 - Listado Alumnos");
            System.out.println("2 - Busca Alumno(DNI)");
            System.out.println("3 - Crear Alumno");
            System.out.println("4 - Modificar Alumno");
            System.out.println("5 - Eliminar Alumno");
            System.out.println("0 - SALIR");
            System.out.println("--------------------------");

            //Introducir datos
            Scanner entrada = new Scanner(System.in);
            System.out.println("Que desea hacer: ");
            dato = entrada.nextLine();

            switch (dato){
                case "0":
                    System.out.println("Hasta la proxima");
                    break;

                case "1":
                    System.out.println("Lista: \n");
                    studentRepository.findAll();
                    break;

                case "2":
                    System.out.println("Introduce el id que quieras buscar: ");
                    id=Integer.parseInt(entrada.nextLine());

                    alumno = studentRepository.findById(id);

                    if (alumno != null) {
                        System.out.println(alumno.toString());
                    }else {
                        System.out.println("El alumno con id: "+id+" no existe");
                    }


                    break;

                case "3":
                    System.out.println("Introduzca los siguientes datos: ");
                    System.out.println("Introduzca el id: ");
                    id=Integer.parseInt(entrada.nextLine());
                    System.out.println("Introduzca el nombre: ");
                    nombre=entrada.nextLine();
                    System.out.println("Introduzca el apellido: ");
                    apellido=entrada.nextLine();
                    System.out.println("Introduzca el cumple: ");
                    cumple=entrada.nextLine();

                    studentRepository.insert(studentRepository.create(id,nombre,apellido,cumple));

                    break;
                case "4":
                    System.out.println("Introduce el id que quieras modificar: ");
                    id=Integer.parseInt(entrada.nextLine());
                    alumno = studentRepository.findById(id);

                    if (alumno != null) {
                        studentRepository.update(alumno);
                        System.out.println("El alumno fue modificado correctamente");

                    }else {
                        System.out.println("El alumno con id: "+id+" no existe");
                    }

                    break;

                case "5":
                    String idd;
                    System.out.println("Introduce el id que quieras ELIMINAR: ");
                    idd=(entrada.nextLine());
                    studentRepository.delete(idd);
                    break;
                default:
                    System.out.println("Escriba un numero del 1 al 5 por favor");
                    break;
            }

        }

        //Cerrar conexion
        cn.close();




    }
}
