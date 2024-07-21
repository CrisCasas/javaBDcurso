package org.example.crisGan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexión con la base que será usada en el resto del proyecto separando la lógica
// operacional de la conexión con la bd

public class DataBaseConnection  {

    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user = "root";
    private static String password = "Hipopotamo.1";

    private static Connection conexion;


    public static Connection getInstance() throws SQLException {
        if(conexion == null){
            conexion = DriverManager.getConnection(url,user,password);
        }
        return conexion;
    }


}
