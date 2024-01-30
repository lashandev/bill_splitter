/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lashan.bill_splitter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Lashan
 */
public class DBConf {

    private static Connection connection;

    private static void createConnection() throws Exception {
        String url = "jdbc:sqlite:E:\\other_project\\bill_splitter\\app_db\\fun_split";
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
    }
    
    public static void iud(String sql)throws Exception{
        if (connection == null) {
            createConnection();
        }
        connection.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet search(String sql)throws Exception{
        if (connection == null) {
            createConnection();
        }
        return connection.createStatement().executeQuery(sql);
    }
    
    public static Connection getConnection(String sql)throws Exception{
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    
    

}
