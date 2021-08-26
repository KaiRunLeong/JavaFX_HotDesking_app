/*
 * Class: CancelBookingController.java
 *
 * Description: The CancelBookingController class will only handle the employeeLogin.fxml file.
 *              It will switch to that fxml file once the return button has been clicked by the user.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CancelBookingController {
    @FXML
    private Button main;

    public void returnToMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/employeeLogin.fxml", main, "Menu(Employee)", 600, 400);
    }
}
