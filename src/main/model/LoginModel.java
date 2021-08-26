/*
 * Class: LoginModel.java
 *
 * Description: The LoginModel class will only allow registered users to enter
 *              the system. It also checks if the user logging in is either an admin
 *              or an employee.
 *
 * Author: kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;

import java.sql.*;

public class LoginModel {

    Connection connection;

    public LoginModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where username = ? and password= ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
           preparedStatement.close();
           resultSet.close();
           connection.close(); //<--
        }
    }

    public Boolean isAdmin(String username) throws SQLException{
        Boolean isAdmin = false;
        connection = SQLConnection.connect();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "select * from employee where username = ? and role = 'admin'";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            rs = preparedStatement.executeQuery();

            if(rs.next() && rs.getString("role").equals("admin")){
                isAdmin = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            preparedStatement.close();
            rs.close();
            connection.close();
        }
        return isAdmin;
    }

    public String getFullName(String username) throws SQLException{
        String result = "";
        String fullName = "";
        ResultSet resultSet=null;
        connection = SQLConnection.connect();
        String sql = "select firstname, last_name from employee where username = '" + username + "';" ;

        try {
            Statement myStmt = connection.createStatement();
            ResultSet myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                fullName = myRs.getString("firstname") + " " + myRs.getString("last_name");
            }

            result = fullName ;
        }catch (Exception e){
            e.printStackTrace();
        }finally{   //<--
            //resultSet.close();
            connection.close();
        }

        return result;
    }

    public int getid(String username) throws SQLException{
        int result = 0;
        String fullName = "";
        ResultSet resultSet=null;
        connection = SQLConnection.connect();

        try {
            String sql = "select id from employee where username = '" + username + "';";

            Statement myStmt = connection.createStatement();
            ResultSet myRs = myStmt.executeQuery(sql);

            result = myRs.getInt("id");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //resultSet.close();
            connection.close();
        }

        return result;
    }

}
