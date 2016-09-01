package com.mora.model;

import java.sql.*;

public class DBConnection {
    public static Connection dbConn = null;
    public Statement dbStmt = null;
    public ResultSet dbRs = null;
    public static String con = "jdbc:mysql://localhost:3306/OF_DB";
    public static String conplus = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    public static String user = "root";
    public static String pass = "root";

    public static Connection setDBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConn = DriverManager.getConnection(con+conplus, user, pass);
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        return dbConn;
        }
    
        public ResultSet getResultSet(String sqlQuery,Connection conn) throws SQLException{
            System.out.println("sqlQuery is:" + sqlQuery);
            String query = sqlQuery;
            dbConn = conn;
            try {
                dbStmt = dbConn.createStatement();
                dbRs = dbStmt.executeQuery(query);
            } catch (Exception exc) {
                exc.printStackTrace();
            } 
            
            return dbRs;
        }
        
}  


