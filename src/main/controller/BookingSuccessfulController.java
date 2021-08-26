/*
 * Class: BookingSuccessfulController.java
 *
 * Description: The BookingSuccessfulController class is only responsible for changing
 *              to a new scene once. For instance, once the user clicks on the return button,
 *              the main menu scene will be displayed.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BookingSuccessfulController {
    @FXML private Button mainMenu;

    public void returnMain(ActionEvent event) {
        SwitchSceneController ssc = new SwitchSceneController();
        ssc.switchScene(event, "../view/employeeLogin.fxml", mainMenu, "Menu(Employee)", 600, 400);
    }

}
