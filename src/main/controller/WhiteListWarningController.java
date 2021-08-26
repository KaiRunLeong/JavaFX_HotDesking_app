/*
 * Class: WhiteListWarningController.java
 *
 * Description: The WhiteListWarningController class handles the whiteListWarning.fxml view.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WhiteListWarningController {
    @FXML private Button mainMenu;

    public void returnMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/employeeLogin.fxml", mainMenu, "Menu Login", 600, 400);
    }
}
