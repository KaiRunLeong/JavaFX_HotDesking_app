/*
 * Class: AdminLoginController.java
 *
 * Description: This class will only be made available to admin users. Upon logging in
 *              if the system detects that the user is an admin, they will be redirected
 *              into the adminLogin.fxml view which will communicate with this controller.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.model.CurrentUserLoginDetailsModel;
import main.model.Initialization;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Label welcomeName;
    @FXML private Button managementButton;
    @FXML private Button viewDeskDetailsButton;
    @FXML private Button releaseBookingButton;
    @FXML private Button generateReportsButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Initialization init = new Initialization();
            init.autoCancel();
            welcomeName.setText("Welcome, " + CurrentUserLoginDetailsModel.getFullName() + "!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void management(ActionEvent event){
        ssc.switchScene(event, "../view/manageEmployee.fxml", managementButton, "Manage Employee", 450, 380);
    }

    public void viewDeskDetails(ActionEvent event){
        ssc.switchScene(event, "../view/viewDeskDetails.fxml", viewDeskDetailsButton, "View Desk Details", 500, 400);
    }

    public void releaseBooking(ActionEvent event){
        ssc.switchScene(event, "../view/releaseBooking.fxml", releaseBookingButton, "Release Booking", 900, 487);
    }

    public void generateReports(ActionEvent event){
        ssc.switchScene(event, "../view/generateReports.fxml", generateReportsButton, "Generate Report", 600, 400);
    }
}
