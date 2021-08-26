/*
 * Class: RejectBookingSuccessfulController.java
 *
 * Description: The RejectBookingSuccessfulController class will handle the
 *              message that contains the status on the rejection of a booking.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RejectBookingSuccessfulController {
    @FXML
    private Button main;

    public void returnToMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/employeeLogin.fxml", main, "Menu(Employee)");
    }
}
