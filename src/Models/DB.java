/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longnh
 */
public class DB {
    private String host_name = "localhost";
    private int port = 3306;
    private String username = "root";
    private String password = "1111";
    private String db_name = "restaurant";
    private Connection conn;
    
    public DB(){
//        System.out.println("DB connecting...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://" + host_name + ":3306/" + db_name;
            conn = DriverManager.getConnection(connectionURL, username, password);
//            System.out.println("DB connected!");
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet execute_query(String query){
        System.out.println(this.getClass() + " SELECT QUERY -> " + query);
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return rs;
        }
    }
    
    public int execute_insert(String query){
        System.out.println(this.getClass() + " INSERT QUERY -> " + query);
        int rtn = 0;
        try {
            Statement stmt = conn.createStatement();
            int affected_rows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            if(affected_rows == 0){
                return -1;
            } else {
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()){
                    rtn = rs.getInt(1);
                    System.out.println("New record created! id -> " + rtn);
                } else {
                    System.out.println("New record not created!");
                    return -1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtn;
    }
    
    public int execute_update(String query){
        System.out.println(this.getClass() + " UPDATE QUERY -> " + query);
        int rtn = 0;
        try {
            Statement stmt = conn.createStatement();
            rtn = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtn;
    }
    
}
