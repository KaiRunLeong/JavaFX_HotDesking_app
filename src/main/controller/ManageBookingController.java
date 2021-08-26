/*
 * Class: ManageBookingController.java
 *
 * Description: The ManageBookingController class will handle the manageAccount.fxml view by
 *              ensuring that the user will be able to either reject or accept a booking.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import main.model.ManageBookingModel;
import java.net.URL;
import java.util.ResourceBundle;


public class ManageBookingController implements Initializable {
    ManageBookingModel mbm = new ManageBookingModel();
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Label tableBooked;
    @FXML private Label warning;
    @FXML private Button reject;
    @FXML private Button checkIn;
    @FXML private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            if(mbm.checkReleaseBooking()){
                tableBooked.setText(mbm.getTableBooked() + " @ " + mbm.getBookingDate() +", " + mbm.getTimeBooked());
            }else{
                tableBooked.setText("Nothing yet, please check back again later");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkInBooking(ActionEvent event){
        try {

            if (mbm.checkReleaseBooking() && mbm.checkInStatus() == false) {
                mbm.userCheckin();
                ssc.switchScene(event, "../view/checkInSuccessful.fxml", checkIn, "Manage Booking");
            }else if(mbm.hasCheckedIn()){
                warning.setText("Already checked in!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void rejectBooking(ActionEvent event){
        try {
            if (mbm.checkReleaseBooking() && mbm.checkInStatus() == false) {
                mbm.userReject();
                ssc.switchScene(event, "../view/rejectBookingSuccessful.fxml", reject, "Manage Booking");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/employeeLogin.fxml", back, "Menu(Employee)", 600, 400);
    }


}
