package org.example.crisGan.repository;
import org.example.crisGan.model.Employee;

import java.sql.SQLException;
import java.util.List;

//Interface que crea el esqueleto de los métodos CRUD
//Aplicando el patrón Repository

public interface Repository <genericType> {

//Cada método debe contar con la excepción SQLException al ejecutar operaciones SQL

    //Método para leer todos los elementos de una tabla
    List<genericType> findAll() throws SQLException;

    //Método para obtener un registro según su id
    genericType getById(Integer id) throws SQLException;

    ////Método para actualizar un registro según su id
    void updateById(Integer id, Employee empleado) throws SQLException;

    //Método para insertar un empleado
    void save(genericType genericType) throws SQLException;

    //Método para eliminar un empleado
    void delete(Integer id) throws SQLException;



}
