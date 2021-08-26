/*
 * Class: CheckInSuccessfulController.java
 *
 * Description: The CheckInSuccessfulController class will switch the scene back to the main
 *              menu once the user clicks on the return button in the checkInSuccessful.fxml button.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CheckInSuccessfulController {
    @FXML
    private Button main;

    public void returnToMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/employeeLogin.fxml", main, "Menu(Employee)", 600, 400);
    }
}
