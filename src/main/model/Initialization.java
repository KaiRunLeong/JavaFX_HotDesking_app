/*
 * Class: Initialization.java
 *
 * Description: The Initialization class will be called each time the login scene is
 *              staged. This class will determine if a booking should be cancelled
 *              automatically.
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

public class Initialization {
    Connection connection;

    /*
     * Description: This method will automatically cancel any bookings that has not been
     *              been approved by the admin before the day of the booking.
     */
    public void autoCancel() throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet myRS = null;

        try{
            String sql = "SELECT booking_id, booking_date FROM bookings WHERE release_booking_status = 'accepted' and checked_in_status = 'pending'";
            myRS = stmt.executeQuery(sql);

            while(myRS.next()){
                setToCancel(myRS.getInt("booking_id"), myRS.getString("booking_date"));
            }

        }catch(Exception e){

        }finally {
            stmt.close();
            myRS.close();
            connection.close();
        }
    }

    public void setToCancel(int bookingID, String dateBooked) throws SQLException {
        Statement stmt = connection.createStatement();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            //Parse booking date and booking time from string to type DATE;
            String bookingDate = dateBooked;
            java.util.Date booking_date = dateFormat.parse(bookingDate);

            //Yesterday's date
            calendar.setTime(booking_date);
            calendar.add(Calendar.DATE, -1);
            calendar.add(Calendar.HOUR_OF_DAY, 23);
            calendar.add(Calendar.MINUTE, 59);
            calendar.add(Calendar.SECOND, 59);
            java.util.Date deadline = calendar.getTime();

            //Today's date
            java.util.Date currentDate = new Date();

            if(currentDate.compareTo(deadline) > 0){
                String sql = "UPDATE bookings SET release_booking_status = 'cancel' WHERE booking_id = " + bookingID;
                stmt.executeUpdate(sql);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }
    }
}
