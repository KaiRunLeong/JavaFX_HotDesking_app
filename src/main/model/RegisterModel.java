/*
 * Class: RegisterModel.java
 *
 * Description: The RegisterModel class will communicate with the database
 *              to add a new user.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.*;

public class RegisterModel {
    Connection connection;

    //START FROM HERE
    public void createNewUser(int employeeID,  String firstname, String lastname, String role,
        String username, String password, String secretQuestion, String answer) throws SQLException{
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try {
            String sql = "INSERT INTO employee VALUES(" + employeeID + ", '" + firstname + "', '" + lastname + "', '" + username +
                    "', '" + password + "', '" + role + "', '" + secretQuestion + "', '" + answer + "'); ";

            myStmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myStmt.close();
            connection.close();
        }
    }

    public void addUserToWhitelist(int employeeID) throws  SQLException{
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try {
            String sql = "INSERT INTO whitelist (employee_id) VALUES (" + employeeID + ")";
            myStmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myStmt.close();
            connection.close();
        }
    }

    public int generateEmployeeID()throws SQLException{
        int result = 0;
        connection = SQLConnection.connect();
        ResultSet myRs = null;
        Statement myStmt = connection.createStatement();

        try{
            String sql = "select id from employee order by id desc LIMIT 0, 1;" ;
            myRs = myStmt.executeQuery(sql);
            result = myRs.getInt("id") + 1;

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //myRs.close();
            myStmt.close();
            connection.close();
        }

        return result;
    }

}
