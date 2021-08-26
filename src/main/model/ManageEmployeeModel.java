/*
 * Class: ManageEmployeeModel.java
 *
 * Description: The ManageEmployeeModel.java class will will act as a model for
 *              ManageEmployeeController.java  class.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;

import java.sql.SQLException;
import java.sql.*;

public class ManageEmployeeModel {
    Connection connection;

    /*
     * Description: This method takes in two parameters and uses it to update the employee's last name
     *              based on the employeeID parameter.
     */
    public void updateLastName(String lastName, int employeeID)throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE employee SET last_name = '" + lastName + "' WHERE id = " + employeeID +
                    ";";
            stmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }
    }

    /*
     * Description: This method deletes an employee account based on the employeeID parameter.
     */
    public void deleteAccount(int employeeID) throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "DELETE FROM employee where id = " + employeeID + ";";
            stmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }
    }

    /*
     * Description: This method takes in two parameters and uses it to update the employee's first name
     *              based on the employeeID parameter.
     */
    public void updateFirstName(String firstName, int employeeID)throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE employee SET firstname = '" + firstName + "' WHERE id = " + employeeID +
                    ";";
            stmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }
    }

    public void updateUsername(String username, int employeeID)throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE employee SET username = '" + username + "' WHERE id = " + employeeID +
                    ";";
            stmt.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }
    }
}
