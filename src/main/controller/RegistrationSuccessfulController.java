/*
 * Class: RegistrationSuccessfulController.java
 *
 * Description: The RegistrationSuccessfulController class will handle the registration
 *              successful message scene.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegistrationSuccessfulController {
   @FXML private Button loginButton;

   public void returnToLogin(ActionEvent event) {
       SwitchSceneController rtlc = new SwitchSceneController();
       rtlc.returnToLogin(event, loginButton);
   }

}
