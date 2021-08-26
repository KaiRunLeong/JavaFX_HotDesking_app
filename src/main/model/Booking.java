/*
 * Class: Booking.java
 *
 * Description: The main purpose of this class is to create an object for a book. The
 *              Book.java class will be used for the release booking feature.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

public class Booking {
    private int booking_id;
    private int employee_id;
    private String fullName;
    private int tableNum;
    private String date;
    private String time;
    private String release_booking_status;

    public Booking(int booking_id, int employee_id, String fullName, int tableNum, String date, String time) {
        this.booking_id = booking_id;
        this.employee_id = employee_id;
        this.fullName = fullName;
        this.tableNum = tableNum;
        this.date = date;
        this.time = time;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
