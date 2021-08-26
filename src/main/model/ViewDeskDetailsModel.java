/*
 * Class: ViewDeskDetailsModel.java
 *
 * Description: The ViewDeskDetailsModel class allows the the admin to
 *              set all of the desk either to either available or lockdown.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.*;

public class ViewDeskDetailsModel {
    Connection connection;

    public void setToNormal() throws SQLException{
        String sql = "UPDATE tables SET table_status = 'Normal' WHERE table_status = 'Covid Condition';";
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try{
            myStmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myStmt.close();
            connection.close();
        }
    }

    public void setToLockDown() throws SQLException{
        String sql = "UPDATE tables SET table_status = 'Covid Condition' WHERE table_status = 'Normal';";
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try{
            myStmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myStmt.close();
            connection.close();
        }
    }

    public boolean isUnderCovidCondition() throws SQLException{
        boolean result = false;
        String sql = "SELECT table_status FROM tables;";
        connection = SQLConnection.connect();
        ResultSet rs = null;
        Statement stmt = connection.createStatement();

        try{
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("table_status").equals("Covid Condition")){
                    result = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            rs.close();
            connection.close();
        }
        return result;
    }

}
