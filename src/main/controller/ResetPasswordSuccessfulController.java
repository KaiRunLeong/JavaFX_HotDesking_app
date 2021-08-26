/*
 * Class: ResetPasswordSuccessfulController.java
 *
 * Description: The ResetPasswordSuccessfulController class will handle the resetPasswordSuccessful.fxml
 *              view.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ResetPasswordSuccessfulController {
    @FXML private Button loginButton;

    public void returnToLogin(ActionEvent event) {
        SwitchSceneController rtlc = new SwitchSceneController();
        rtlc.returnToLogin(event, loginButton);
    }
}
