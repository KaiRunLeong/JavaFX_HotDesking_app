/*
 * Class: ReleaseBookingModel.java
 *
 * Description: The ReleaseBookingModel will retrieve all bookings that is still
 *              pending for the admin.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.SQLConnection;

public class ReleaseBookingModel {
    Connection connection;

    public ObservableList<Booking>getAllBooking() throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = null;
        ObservableList<Booking> booking = FXCollections.observableArrayList();

        try{
            String sql = "SELECT * FROM Bookings WHERE release_booking_status = 'pending';";
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int bookingId = rs.getInt("booking_id");
                int employeeId = rs.getInt("employee_id");
                String fullName = getEmployeeName(employeeId);
                int tableNum = rs.getInt("table_number");
                String bookingDate = rs.getString("booking_date");
                String bookingTime = rs.getString("booking_time");

                booking.add(new Booking(bookingId, employeeId, fullName, tableNum, bookingDate, bookingTime));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            rs.close();
            connection.close();
        }

        return booking;
    }


    public String getEmployeeName(int employeeID) throws SQLException{
        String fullName = "";
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet myRs = null;

        try{
            String sql = "SELECT firstname, last_name FROM employee WHERE id = " + employeeID + ";";
            myRs = stmt.executeQuery(sql);

            if(myRs.next()){
                fullName = myRs.getString("firstname") + " " + myRs.getString("last_name");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            myRs.close();
            connection.close();
        }

        return fullName;
    }

    public void updateReleaseStatus(int bookingID, String status) throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "UPDATE bookings SET release_booking_status = '" + status + "' WHERE booking_id = " + bookingID + ";";
            stmt.executeUpdate(sql);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            stmt.close();
            connection.close();
        }
    }



}
