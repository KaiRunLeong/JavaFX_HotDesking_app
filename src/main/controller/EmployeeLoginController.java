/*
 * Class: EmployeeLoginController.java
 *
 * Description: This class will only be made to users who has the role of an employee. Upon
 *              logging in, if the system detects that the user is an employee, they will be
 *              redirected to this page.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import main.model.CurrentUserLoginDetailsModel;
import main.model.Initialization;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeLoginController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Label welcomeName;
    @FXML private Button book;
    @FXML private Button manageBookingButton;
    @FXML private Button manageAccountButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Initialization init = new Initialization();
            init.autoCancel();
            welcomeName.setText("Welcome, " + CurrentUserLoginDetailsModel.getFullName() + "!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void bookTable(ActionEvent event) {
        ssc.switchScene(event, "../view/book.fxml", book, "Book", 600, 400);
    }

    public void manageBooking(ActionEvent event){
        ssc.switchScene(event, "../view/manageBooking.fxml", manageBookingButton, "Manage Booking", 600, 400);
    }

    public void manageAccount(ActionEvent event){
        ssc.switchScene(event, "../view/manageAccount.fxml", manageAccountButton, "Manage Account", 473, 412);
    }
}
