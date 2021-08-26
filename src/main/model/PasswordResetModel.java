/*
 * Class: PasswordResetModel.java
 *
 * Description: The model class will communicate with the database to
 *              allow the user to reset their password
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.*;

public class PasswordResetModel {

    Connection connection;

    public PasswordResetModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);
    }


    public boolean checkValidUser(String user) throws SQLException{
        boolean result = true;

        Statement myStmt = connection.createStatement();
        ResultSet myRs = myStmt.executeQuery("select * from employee where username = '" + user + "';");

        if (myRs.next()){
            result = true;
        }else{
            result = false;
        }

        myRs.close();
        return result;
    }



    public String getSecurityQuestion(String user) throws SQLException{
        ResultSet myRs = null;
        String question = "";

        try{
            Statement myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select secret_question from employee where username = '" + user + "';");
            question = myRs.getString("secret_question");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            myRs.close();
            connection.close();
        }

        return question;
    }

}
