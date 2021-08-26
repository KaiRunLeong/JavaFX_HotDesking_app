/*
 * Class: DeleteBookingController.java
 *
 * Description: The DeleteBookingController class will handle the status of a booking
 *              by communicating with the DeleteBookingModel and determine if the cancelBooking.fxml
 *              scene should be called.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.model.BookATableModel;
import main.model.DeleteBookingModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeleteBookingController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    DeleteBookingModel dbm = new DeleteBookingModel();
    BookATableModel btm = new BookATableModel();
    @FXML private Label tableBooked;
    @FXML private Button cancelButton;
    @FXML private Button back;

    public void initialize(URL location, ResourceBundle resources){
         try {
            if(dbm.checkValidation() == false){
                tableBooked.setText("No bookings found!");
            }else if(btm.userAlreadyBooked()){
                tableBooked.setText(dbm.getBooking());
            }else{
                tableBooked.setText("No bookings found!");
            }

         }catch (Exception e){
             e.printStackTrace();
         }
    }

    public void cancelBooking(ActionEvent event){
        try{
            if(!tableBooked.getText().equals("No bookings found!") && dbm.checkValidation()){
                dbm.deleteBooking();
                ssc.switchScene(event, "../view/cancelBooking.fxml", cancelButton, "Cancel Booking");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event)throws SQLException {
        ssc.switchScene(event, "../view/book.fxml", back, "Book", 600, 400);
    }

}
