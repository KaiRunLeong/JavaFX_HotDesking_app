/*
 * Class: CovidConditionModel.java
 *
 * Description: This class will only be made available to admin users where
 *              they will be able individual tables to covid condition.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.*;
import java.util.ArrayList;

public class CovidConditionModel {
    Connection connection;

    public void setToCovidCondition(int tableNum) throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE tables SET table_status = 'Covid Condition' WHERE table_number = " + tableNum + ";";
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }
    }

    public ArrayList<Integer>lockedTables() throws SQLException{
        ArrayList<Integer>tablesLocked = new ArrayList<Integer>();
        connection = SQLConnection.connect();
        ResultSet rs = null;
        Statement stmt = connection.createStatement();

        try{
            String sql = "SELECT table_number FROM tables WHERE table_status = 'Covid Condition';";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                tablesLocked.add(rs.getInt("table_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }

        return tablesLocked;
    }

    public boolean isLocked(int tableNum) throws SQLException{
        boolean isLocked = false;
        connection = SQLConnection.connect();
        ResultSet myRs = null;
        Statement stmt = connection.createStatement();

        try{
            String sql = "SELECT table_status FROM tables WHERE table_number = " + tableNum + ";";
            myRs = stmt.executeQuery(sql);

            if(myRs.getString("table_status").equals("Covid Condition")){
                isLocked = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            myRs.close();
            connection.close();
        }

        return isLocked;
    }

    public void setToAvailable(int tableNum) throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE tables SET table_status = 'Normal' WHERE table_number = " + tableNum + ";";
            stmt.executeUpdate(sql);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
