/*
 * Class: BookATableModel.java
 *
 * Description: This class is responsible for allowing the employee to choose a table
 *              to book. It allows the system to ensure that only one booking has been
 *              made and that booking is allowed.
 *
 * Author: Kai Run Leoong (s3862092)
 */

package main.model;

import main.SQLConnection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;


public class BookATableModel {
    Connection connection;
    CovidConditionModel ccm = new CovidConditionModel();
    private int employeeID = CurrentUserLoginDetailsModel.getEmployeeID();
    ArrayList<Integer> result = new ArrayList<Integer>();

    /*
     * Description: This method will retrieve all table numbers that have been booked based on the
     *              date and time chosen by the employee
     */
    public ArrayList<Integer> tablesBooked (String date, String time) throws SQLException{
        ResultSet rs = null;
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "SELECT table_number  FROM bookings WHERE booking_time = '" + time + "' and booking_date = '" + date + "';";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                this.result.add(rs.getInt("table_number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            rs.close();
            connection.close();
        }

        return this.result;
    }

    /*
     * Description: If a table has been locked, the method will return false
     *              so that the table in the graphical user interface will not
     *              respond upon the click action.
     */
    public boolean clickable(int tableNum){
        boolean clickable = true;

        try {
            if (ccm.isLocked(tableNum)) {
                clickable = false;
            }else {
                for (int i : result) {
                    if (tableNum == i) {
                        clickable = false;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return clickable;
    }

    /*
     * Description: Each time a new booking is made, a new booking ID will be made automatically.
     *              This method will retrieve the booking ID with the highest integer value, then
     *              add one to the value. The new value will then be the new booking ID.
     */
    public int generateBookingID() throws SQLException{
        int result = 0;
        connection = SQLConnection.connect();
        ResultSet myrs = null;
        Statement myStmt = connection.createStatement();

        try{
            String sql = "select booking_id from bookings order by booking_id desc LIMIT 0, 1;" ;
            myrs = myStmt.executeQuery(sql);
            result = myrs.getInt("booking_id") + 1;

        }catch(SQLException sqlException){


        }catch (Exception e){
            e.printStackTrace();
        }finally{
            myrs.close();
            myStmt.close();
            connection.close();
        }
        return result;
    }

    /*
     * Description: This method will retrieve today's time using the Data class found
     *              in java.util.
     */
    public String getCurrentTime(String pattern){
        Date currentDate = new java.util.Date();
        SimpleDateFormat time = new SimpleDateFormat(pattern);
        return time.format(currentDate);
    }

    /*
     * Description: This method will retrieve today's date using the Data class found
     *              in java.util.
     */
    public String getCurrentDate(String pattern){
        Date currentDate = new Date();
        SimpleDateFormat date = new SimpleDateFormat(pattern);
        return date.format(currentDate);
    }

    public void bookTableNow(int tableNum, String time, String date) throws SQLException{
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try{
            String sql = "INSERT INTO bookings VALUES(" + generateBookingID() + ", " + employeeID + ", " + tableNum + ", '" +
                    date + "', '" + time + "', '" + "pending" + "', '" + getCurrentTime("HH:mm:ss") + "', '" + getCurrentDate("yyyy-MM-dd") +
                    "', 'pending'" + ");";
            stmt.executeUpdate(sql);
            updateWhitelist(tableNum);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            connection.close();
        }

    }

    /*
     * Description: This method will be used to check if the user still has an active booking
     *              , if the user does not have an active booking then the user will be able to book
     */
    public boolean userAlreadyBooked() throws SQLException {
        boolean result = false;
        ResultSet resultSet = null;
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();

        try {
            String sql = "SELECT release_booking_status, booking_date, booking_time FROM bookings WHERE employee_id = " + employeeID + " ORDER BY booking_id DESC LIMIT 0, 1";
            resultSet = stmt.executeQuery(sql);

            String bookingDate = resultSet.getString("booking_date");
            String bookingEndTime = resultSet.getString("booking_time").substring(8);
            String release_booking_status = resultSet.getString("release_booking_status");

            if (resultSet.next() && haveNotPassedDateTime(bookingDate, bookingEndTime) == true && (release_booking_status.equals("accepted") || release_booking_status.equals("pending"))) {
                result = true;
            }

        }catch(SQLException sqlException){


        }catch (Exception e){
            e.printStackTrace();
        }finally{
            stmt.close();
            resultSet.close();
            connection.close();
        }

        return result;
    }

    public boolean haveNotPassedDateTime(String bookingDate, String bookingTime){
        boolean result = false;

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            String bookingDateTime = bookingDate + " " + bookingTime;
            String currentDateTime = getCurrentDate("yyyy-MM-dd") + " " + getCurrentTime("HH:mm");
            Date dateTime = dateFormat.parse(bookingDateTime);
            Date currDateTime = dateFormat.parse(currentDateTime);

            if(dateTime.compareTo(currDateTime) >= 0) {
                result = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

       return result;
    }

    /*
     * Description: The whiteList() method will ensure that the user does not book the same
     *              table as the previous booking. If the user clicks on the same table as the
     *              previous booking, then a whitelist warning will appear and the user will be
     *              redirected to the main page.
     */
    public int whiteList() throws SQLException{
        int previousTable = 0;
        connection = SQLConnection.connect();
        ResultSet reSet = null;
        Statement myStmt = connection.createStatement();

        try{
            String sql = "SELECT table_number FROM whitelist WHERE employee_id = " + employeeID + ";";
            reSet = myStmt.executeQuery(sql);

            if(reSet.next()){
                previousTable = reSet.getInt("table_number");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reSet.close();
            myStmt.close();
            connection.close();
        }
        return previousTable;
    }

    public void updateWhitelist(int tableNum) throws SQLException{
        connection = SQLConnection.connect();
        Statement myStmt = connection.createStatement();

        try{
            String sql = "UPDATE whitelist SET table_number = " +  tableNum + " WHERE employee_id = " +
                    employeeID +";";
            myStmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myStmt.close();
            connection.close();
        }
    }


}
