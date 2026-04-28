/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaadday5;

import java.sql.*;

/**
 *
 * @author tangh
 */
public class DBConnection {
    private static Connection connection;
    
    private static final String URL= "jdbc:sqlserver://localhost:1433;databaseName=StudentDb";
    private static final String USER = "sa";
    private static final String PASSWORD ="tuantu209423";
    
    private DBConnection(){};
    
    public static synchronized Connection getConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }else{
                System.out.println("Already connect");
            }
        }catch(Exception e){
            System.out.println("Error connect: " + e.getMessage());
        }
        return connection;
    }
}
