/*
 * Class: EmployeeUpdatedController.java
 *
 * Description: The EmployeeUpdatedController class will switch to the adminLogin.fxml
 *              scene once the the admin user clicks on the return button
 *
 * Author : Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EmployeeUpdatedController {
    @FXML
    private Button main;

    public void returnToMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/adminLogin.fxml", main, "Menu(admin)", 600, 400);
    }
}
