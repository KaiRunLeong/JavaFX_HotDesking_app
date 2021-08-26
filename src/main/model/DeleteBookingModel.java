/*
 * Class: DeleteBookingModel.java
 *
 * Description: The DeleteBookingModel class will provide information to the system by
 *              checking the database if the user has an active booking that can be
 *              cancelled.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.SQLConnection;

public class DeleteBookingModel {

    int employeeID = CurrentUserLoginDetailsModel.getEmployeeID();
    Connection connection;

    /*
     * Description: This method will get any active booking that was made by the user, if no
     *              active bookings were found then a "No bookings found!" string will be returned.
     */
    public String getBooking() throws SQLException{
        String result = "No bookings found!";
        connection = SQLConnection.connect();
        ResultSet rs = null;
        Statement stmt = connection.createStatement();

        try {
            String sql = "SELECT booking_date, booking_time, table_number FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1";
            rs = stmt.executeQuery(sql);

            int tableNum = 0;
            String bookingTime = "";
            String bookingDate = "";

            while (rs.next()) {
                tableNum = rs.getInt("table_number");
                bookingTime = rs.getString("booking_time");
                bookingDate = rs.getString("booking_date");
            }

            result = String.format("Cancel Table %d from %s at %s", tableNum, bookingTime, bookingDate);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            rs.close();
            stmt.close();
            connection.close();
        }
        return result;
    }

    public void deleteBooking() throws SQLException{
        connection = SQLConnection.connect();
        ResultSet myrs = null;
        Statement stmt = connection.createStatement();

        try{
            int bookingID = -1;
            String dateBooked = "";
            String timeBooked = "";
            String sql = "SELECT booking_id, date_booked, time_booked FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1";
            myrs = stmt.executeQuery(sql);
            if(myrs.next()){
                bookingID = myrs.getInt("booking_id");
                dateBooked = myrs.getString("date_booked");
                timeBooked = myrs.getString("time_booked");
            }

            if(bookingID != -1) {
                sql = "UPDATE bookings SET release_booking_status = 'cancel' WHERE employee_id = " + employeeID + " and booking_id = " + bookingID;
                stmt.executeUpdate(sql);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
            myrs.close();
            connection.close();
        }
    }

    private boolean validationPassed(String dateBooked, String timeBooked){
        boolean result = false;

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            //Parse booking date and booking time from string to type DATE;
            String bookingDateTime = dateBooked + " " + timeBooked;
            Date dateTime = dateFormat.parse(bookingDateTime);

            //48 hours from time booked and date booked
            calendar.setTime(dateTime);
            calendar.add(Calendar.DATE, 2);
            Date timeValidation = calendar.getTime();

            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            currentDate = dateFormat.parse(simpleDateFormat.format(currentDate));

            if(currentDate.compareTo(timeValidation) >= 0) {
                result = true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean checkValidation() throws SQLException{
        boolean result = true;
        connection = SQLConnection.connect();
        ResultSet myRS = null;
        Statement stmt = connection.createStatement();

        try {
            String dateBooked = "";
            String timeBooked = "";
            String sql = "SELECT date_booked, time_booked FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1";
            myRS = stmt.executeQuery(sql);

            if (myRS.next()) {
                dateBooked = myRS.getString("date_booked");
                timeBooked = myRS.getString("time_booked");

                if (validationPassed(dateBooked, timeBooked)) {
                    result = false;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
            myRS.close();
            connection.close();
        }
        return result;
    }
}
