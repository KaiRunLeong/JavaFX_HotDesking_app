/*
 * Class: BookController.java
 *
 * Description: The BookController will change the view depending on which button
 *              the user clicks on, which is either "Make a booking" or "Cancel a Booking".
 *
 * Author: Kai Run Leong (s3862092)
*/
package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class BookController {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Button makeBooking;
    @FXML private Button cancelBooking;
    @FXML private Button back;

    public void bookTable(ActionEvent event){
        ssc.switchScene(event, "../view/makeBooking.fxml", makeBooking, "Book", 453, 453);
    }

    public void cancelBooking(ActionEvent event){
        ssc.switchScene(event, "../view/deleteBooking.fxml", cancelBooking, "Book", 433, 400);
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/employeeLogin.fxml", back, "Menu(Employee)", 600, 400);
    }
}
