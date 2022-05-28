package es.eoi.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementMain {
    public static void main(String[] args) throws SQLException {
        //Conexion bbdd
        final String url = "jdbc:mysql://127.0.0.1:3306/jdbcproject";
        final String user = "root";
        final String password = "1234";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(String.format("Already Connected to  %s", url));


        //Declaracion
        String dato= "";

        //Main
        while(dato.equals("0")) {
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

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                default:
                    System.out.println("Escriba un numero del 1 al 5 por favor");
                    break;
            }

        }

        //Cerrar conexion
        connection.close();




    }
}
