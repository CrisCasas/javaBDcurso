package org.example.crisGan.main;

import org.example.crisGan.model.Employee;
import org.example.crisGan.repository.EmployeeRepository;
import org.example.crisGan.repository.Repository;
import org.example.crisGan.util.DataBaseConnection;
import view.SwingApp;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        SwingApp app= new SwingApp();
        app.setVisible(true);

    }
}