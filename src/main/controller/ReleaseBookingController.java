/*
 * Class: ReleaseBookingController.java
 *
 * Description: The ReleaseBookingController class will display the necessary
 *              bookings that requires the admin's approval.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.model.Booking;
import main.model.ReleaseBookingModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

public class ReleaseBookingController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    ReleaseBookingModel rbm = new ReleaseBookingModel();
    @FXML private TableView<Booking>tableView;
    @FXML private TableColumn <Booking, Integer> bookingID;
    @FXML private TableColumn <Booking, Integer> empID;
    @FXML private TableColumn <Booking, String >fullName;
    @FXML private TableColumn <Booking, Integer> tableNum;
    @FXML private TableColumn <Booking, String> date;
    @FXML private TableColumn <Booking, String> time;
    @FXML private TableColumn <Booking, String> timeValidation;
    @FXML private TextField inputID;
    @FXML private RadioButton acceptButton;
    @FXML private RadioButton rejectButton;
    @FXML private Button releaseButton;
    @FXML private Button back;
    private String status;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            bookingID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("booking_id"));
            empID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("employee_id"));
            fullName.setCellValueFactory(new PropertyValueFactory<Booking, String>("fullName"));
            tableNum.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("tableNum"));
            date.setCellValueFactory(new PropertyValueFactory<Booking, String>("date"));
            time.setCellValueFactory(new PropertyValueFactory<Booking, String>("time"));
            tableView.setItems(getBookings());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<Booking> getBookings(){
        ObservableList<Booking> booking = FXCollections.observableArrayList();
        try {
            booking = rbm.getAllBooking();
        }catch (Exception e){
            e.printStackTrace();
        }

        return booking;
    }

    public void update(ActionEvent event) throws SQLException {
        rbm.updateReleaseStatus(Integer.parseInt(inputID.getText()), status);
        ssc.switchScene(event, "../view/releaseBooking.fxml", releaseButton, "Release Booking", 900, 487);
    }

    public void getStatus(ActionEvent event){
        if(acceptButton.isSelected()){
            status = "accepted";
        }else if(rejectButton.isSelected()){
            status = "rejected";
        }
    }

    public void previousPage(ActionEvent event)throws SQLException{
        ssc.switchScene(event, "../view/adminLogin.fxml", back, "Book", 600, 400);
    }
}

