/*
 * Class: SecurityQuestionModel.java
 *
 * Description: The SecurityQuestionModel class will retrieve the security question
 *              and determine if the password can be reset based on the authentication.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecurityQuestionModel {
    Connection connection;

    public SecurityQuestionModel(){
        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);
    }

    /*
     * Description: This method has two parameters and will update the user's password based
     *              on the user parameter.
     */
    public void changePassword(String user, String newPass) throws SQLException{
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try {
            String sql = "UPDATE Employee SET password = \"" + newPass + "\" WHERE username = \"" + user + "\";";
            myStmt.executeUpdate(sql);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }

    public boolean checkAnswer(String user, String answer)throws SQLException{
        boolean status = false;
        ResultSet myRs = null;
        connection = SQLConnection.connect();

        try {
            Statement myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select answer from employee where username = '" + user + "';");

            if (answer.equals(myRs.getString("answer"))) {
                status = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myRs.close();
            connection.close();
        }

        return status;

    }
}