package org.example.crisGan.main;

import org.example.crisGan.model.Employee;
import org.example.crisGan.repository.EmployeeRepository;
import org.example.crisGan.repository.Repository;
import org.example.crisGan.util.DataBaseConnection;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {


        try (Connection conexion = DataBaseConnection.getInstance()){

            Repository<Employee> repository = new EmployeeRepository();

            System.out.println("---Listando-------");
            repository.findAll().forEach(System.out::println);

////            System.out.println("-------------Insertando un Empleado------------");
//            Employee empleado= new Employee();
////            empleado.setFirst_name("Diego");
////            empleado.setPa_surname("Mendoza");
////            empleado.setMa_surname("Lozano");
////            empleado.setEmail("diego@gmail.com");
////            empleado.setSalary(20000.00f);
//
//            System.out.println("-------------Actualizando un Empleado------------");
//
//            empleado.setFirst_name("Armando");
//            empleado.setPa_surname("Mendoza");
//            empleado.setMa_surname("Lozano");
//            empleado.setEmail("diego@gmail.com");
//            empleado.setSalary(20000.00f);
//            repository.updateById(7,empleado);

            //repository.save(empleado);
            System.out.println("Eliminando empleado");
            repository.delete(7);



            System.out.println("-----Empleado-------");

            repository.findAll().forEach(System.out::println);







        }


    }
}