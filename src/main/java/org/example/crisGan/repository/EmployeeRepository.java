package org.example.crisGan.repository;

import org.example.crisGan.model.Employee;
import org.example.crisGan.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements  Repository<Employee>{

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    @Override
    public List<Employee> findAll() throws SQLException {

        List<Employee> employees = new ArrayList<>();

        try(
                Statement sentencia = getConnection().createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM employees");
        ){
            while ((resultado.next())){
                Employee empleado = crearEmployee(resultado);
                employees.add(empleado);
            }

        }
        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {

        Employee employee = null;

        try(PreparedStatement sentencia = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?");){

            sentencia.setInt(1,id);

            try(ResultSet resultado= sentencia.executeQuery()){
                if(resultado.next()){
                    employee = crearEmployee(resultado);
                }
            }
        }
            return employee;
    }

    @Override
    public void updateById(Integer id, Employee empleado) throws SQLException {

        if(getById(id)!=null){
            String consultaSQL= "UPDATE employees SET first_name = ?, pa_surname = ?,ma_surname = ?,email = ?,salary = ? WHERE id ="+id;
            try(PreparedStatement sentencia = getConnection().prepareStatement(consultaSQL)){
                sentencia.setString(1,empleado.getFirst_name());
                sentencia.setString(2,empleado.getPa_surname());
                sentencia.setString(3,empleado.getMa_surname());
                sentencia.setString(4,empleado.getEmail());
                sentencia.setFloat(5,empleado.getSalary());
                sentencia.executeUpdate();
            }
            System.out.println("El empleado existe, registro actualizado exitosamente");
        }else {
            save(empleado);
            System.out.println("El empleado no existe");
        }

    }

    @Override
    public void save(Employee empleado) throws SQLException {

        String sql = "INSERT INTO employees (first_name, pa_surname,ma_surname,email,salary) VALUES (?,?,?,?,?)";

        try (PreparedStatement sentencia= getConnection().prepareStatement(sql)){

            sentencia.setString(1,empleado.getFirst_name());
            sentencia.setString(2,empleado.getPa_surname());
            sentencia.setString(3,empleado.getMa_surname());
            sentencia.setString(4,empleado.getEmail());
            sentencia.setFloat(5,empleado.getSalary());

            sentencia.executeUpdate();

        }

    }



    @Override
    public void delete(Integer id) throws SQLException {

        try(PreparedStatement sentencia = getConnection().prepareStatement("DELETE FROM employees where id = ?")){

            sentencia.setInt(1,id);
            sentencia.executeUpdate();

        }

    }

    private Employee crearEmployee(ResultSet resultado) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultado.getInt("id"));
        employee.setFirst_name(resultado.getString("first_name"));
        employee.setPa_surname(resultado.getString(("pa_surname")));
        employee.setMa_surname(resultado.getString(("ma_surname")));
        employee.setEmail(resultado.getString("email"));
        employee.setSalary(resultado.getFloat("salary"));
        return  employee;
    }
}
