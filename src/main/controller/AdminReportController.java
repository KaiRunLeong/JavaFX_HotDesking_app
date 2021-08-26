/*
 * Class: AdminReportController.java
 *
 * Description: The AdminReportController class will call methods from the AdminReportModel
 *              class to generate CSV files from the employee and booking tables in the database
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import main.model.AdminReportModel;

import java.io.IOException;
import java.sql.SQLException;

public class AdminReportController {
    SwitchSceneController ssc = new SwitchSceneController();
    AdminReportModel arm = new AdminReportModel();
    @FXML private Hyperlink bookingReport;
    @FXML private Hyperlink employeeReport;
    @FXML private Button back;

    public void bookingCSV(ActionEvent event) throws SQLException, IOException {
        arm.generateBookingsCSV();
    }

    public void employeeCSV(ActionEvent event)throws SQLException, IOException{
        arm.generateEmployeeCSV();
    }

    public void previousPage(ActionEvent event) {
        ssc.switchScene(event, "../view/adminLogin.fxml", back, "Book", 600, 400);
    }
}
