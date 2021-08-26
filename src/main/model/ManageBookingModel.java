/*
 * Class: ManageBookingModel.java
 *
 * Description: This class will provide information for employee check in.
 *
 * Author: Kai Run Leong (S3862092)
 */

package main.model;

import main.SQLConnection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class ManageBookingModel {
    Connection connection;
    int employeeID = CurrentUserLoginDetailsModel.getEmployeeID();

    public String getBookingDate()throws SQLException{
        String bookingDate = "";
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = null;

        try{
            String sql = "SELECT booking_date FROM bookings WHERE employee_id = " + employeeID +
                    " ORDER BY booking_id desc LIMIT 0, 1;";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                bookingDate = rs.getString("booking_date");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rs.close();
            connection.close();
        }
        return bookingDate;
    }

    public String getTableBooked() throws SQLException{
        String tableBooked = "";
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet myRs = null;

        try{
            String sql = "SELECT table_number FROM bookings WHERE employee_id = " + employeeID +
                    " ORDER BY booking_id DESC LIMIT 0, 1;";
            myRs = stmt.executeQuery(sql);

            if(myRs.next()) {
                tableBooked = "Table " + myRs.getInt("table_number");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myRs.close();
            stmt.close();
            connection.close();
        }

        return tableBooked;
    }

    public String getTimeBooked()throws SQLException{
        String timeBooked = null;
        String timeStart = "";
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = null;

        try{
            String sql = "SELECT booking_time FROM bookings WHERE employee_id = " + employeeID +
                    " ORDER BY booking_id DESC LIMIT 0, 1;";
            resultSet = stmt.executeQuery(sql);

            if(resultSet.next()){
                timeBooked = resultSet.getString("booking_time");
                timeStart = timeBooked.substring(0, timeBooked.indexOf("-"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            resultSet.close();
            stmt.close();
            connection.close();
        }

        return timeStart;
    }

    public boolean checkReleaseBooking()throws SQLException{
        boolean result = false;
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet result_set = null;

        try{
            String sql = "SELECT release_booking_status FROM bookings WHERE employee_id = " + employeeID +
                    " ORDER BY booking_id DESC LIMIT 0, 1;";
            result_set = stmt.executeQuery(sql);

            if(result_set.next() && result_set.getString("release_booking_status").equals("accepted")){
                result = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            result_set.close();
            stmt.close();
            connection.close();
        }

        return result;
    }

    public void userCheckin()throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE bookings SET checked_in_status = 'Checked In' WHERE employee_id =" + employeeID + ";";
            stmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
            connection.close();
        }

    }

    public boolean hasCheckedIn() throws SQLException{
        boolean result = false;
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet myResult = null;

        try{
            String sql = "SELECT checked_in_status FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1;";
            myResult = stmt.executeQuery(sql);

            if(myResult.getString("checked_in_status").equals("Checked In") || myResult.getString("checked_in_status").equals("Rejected")){
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            myResult.close();
            connection.close();
        }

        return result;
    }

    public void userReject()throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE bookings SET checked_in_status = 'Rejected' WHERE employee_id =" + employeeID + ";";
            stmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
            connection.close();
        }

    }

    public boolean checkInStatus() throws SQLException{
        boolean checkedIn = false;
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet resultset = null;

        try{
            String sql = "SELECT checked_in_status FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1;";
            resultset = stmt.executeQuery(sql);
            String checkInStatus = resultset.getString("checked_in_status");

            if(checkInStatus.equals("Checked In") || checkInStatus.equals("Rejected")){
                checkedIn = true;
            }

        }catch(Exception e){

        }finally{
            stmt.close();
            resultset.close();
            connection.close();
        }

        return checkedIn;
    }



}
