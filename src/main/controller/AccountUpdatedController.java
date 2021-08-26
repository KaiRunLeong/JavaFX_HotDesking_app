/*
 * Class: AccountUpdatedController.java
 *
 * Description: The AccountUpdatedController class controls the view that
 *              display the status of the updated account
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccountUpdatedController {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Button main;

    public void returnToMain(ActionEvent event){
        ssc.switchScene(event, "../view/employeeLogin.fxml", main, "Menu(Employee)", 600, 400);
    }
}
