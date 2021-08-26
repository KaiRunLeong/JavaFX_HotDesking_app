/*
 * Class: ManageAccountModel.java
 *
 * Description: The ManageAccountModel.java is can be used by the users to
 *              update the users information.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.*;

public class ManageAccountModel {

    Connection connection;
    private int employeeID = CurrentUserLoginDetailsModel.getEmployeeID();

    /*
     * Description: This method will connect to the sqlite database and delete the user based
     *              on the current employeeID.
     */
    public void deleteAccount() throws SQLException{
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

    public void updateFirstName(String firstName)throws SQLException{
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

    public void updateLastName(String lastName)throws SQLException{
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

    public void updateUsername(String username)throws SQLException{
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
