/*
 * Class: AccountDeletedController.java
 *
 * Description: The AccountDeletedController class will allow the user
 *              to control the view. A message on the status of the deletion
 *              of an account will be shown in the view page.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccountDeletedController{
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Button login;

    public void returnToLogin(ActionEvent event){
        ssc.switchScene(event, "../view/login.fxml", login, "Menu(Admin)", 400, 400);
    }

}
