/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingaspx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cep
 */
public class EjemploSingleton {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private EjemploSingleton(){

    String url = "jdbc:mysql://localhost:3306/facial_recognition";
    String driver = "com.mysql.cj.jdbc.Driver";
    String usuario = "root";
    String password = "";
  
 try{
     Class.forName(driver);
     conn = DriverManager.getConnection(url, usuario, password);
 }
 catch(ClassNotFoundException | SQLException e){
     e.printStackTrace();
 }
    } // Fin constructor
 
    // Métodos
    public static Connection getConnection(){
  
 if (conn == null){
     new EjemploSingleton();
 }
        System.out.println("correcto");
 return conn;
    } // Fin getConnection
	
	
public static Connection cerrarConexion()
{
if (conn != null)
{
	try {
		conn.close();
	} catch (SQLException ex) {
		Logger.getLogger(EjemploSingleton.class.getName()).log(Level.SEVERE, null, ex);
	}
}
return conn;
}

public static void main(String[] args){
   
   Connection conn=null;
    conn = EjemploSingleton.getConnection();
		
}
	
}
