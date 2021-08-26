/*
 * Class: AdminReportModel.java
 *
 * Description: The AdminReportModel.java class will allow admin users to generate
 *              CSV reports that either contains information on bookings or employees.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import main.SQLConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

import java.sql.*;

public class AdminReportModel {

    Connection connection;

    /*
     * Description: This method will retrieve all necessary information from the booking table
     *              from the sqlite database and input it into a csv file.
     */
    public void generateBookingsCSV() throws SQLException, IOException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = null;
        int bookingID, employeeID, tableNumber;
        String bookingDate, bookingTime, release_booking_status, time_booked, date_booked, checked_in_status;
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Bookings.csv")));

        try{
            String sql = "SELECT * FROM bookings;";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                bookingID = rs.getInt("booking_id");
                employeeID = rs.getInt("employee_id");
                tableNumber = rs.getInt("table_number");
                bookingDate = rs.getString("booking_date");
                bookingTime = rs.getString("booking_time");
                release_booking_status = rs.getString("release_booking_status");
                time_booked = rs.getString("time_booked");
                date_booked = rs.getString("date_booked");
                checked_in_status = rs.getString("checked_in_status");

                pw.println(bookingID + addComma() + employeeID + addComma() + tableNumber + addComma() + bookingDate + addComma() + bookingTime + addComma() +
                        release_booking_status + addComma() + time_booked + addComma() + date_booked + addComma() + checked_in_status);

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pw.close();
            stmt.close();
            rs.close();
            connection.close();
        }
    }

    /*
     * Description: This method will retrieve all necessary information from the employee table
     *              from the sqlite database and input it into a csv file.
     */
    public void generateEmployeeCSV()throws SQLException, IOException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet myRs = null;
        int id;
        String firstName, lastName, username, role, secret_question, answer;
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Employee.csv")));

        try{
            String sql = "SELECT * FROM employee;";
            myRs = stmt.executeQuery(sql);

            while(myRs.next()){
                id = myRs.getInt("id");
                firstName = myRs.getString("firstname");
                lastName = myRs.getString("last_name");
                username = myRs.getString("username");
                role = myRs.getString("role");
                secret_question = myRs.getString("secret_question");
                answer = myRs.getString("answer");

                pw.println(id + addComma() + firstName + addComma() + lastName + addComma() + username + addComma() + role +
                        addComma() + secret_question + addComma() + answer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            pw.close();
            stmt.close();
            myRs.close();
            connection.close();
        }
    }


    private String addComma(){
        String comma = ", ";
        return comma;
    }
}
