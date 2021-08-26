/*
 * Class: GenerateReportsController.java
 *
 * Description: The GenerateReportsController class will handle a total of three buttons.
 *              The back button will return to the previous page, the reportButton will
 *              switch to a new scene that will allow the admin user to generate reports
 *              and the viewTableButton which displays the current table allocation.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GenerateReportsController {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Button reportButton;
    @FXML private Button viewTableButton;
    @FXML private Button back;

    public void adminReport(ActionEvent event){
        ssc.switchScene(event, "../view/adminReport.fxml", reportButton, "Admin Report", 600, 400);
    }

    public void viewTableAllocation(ActionEvent event){
        ssc.switchScene(event, "../view/viewTableAllocation.fxml", viewTableButton, "View Table Allocation", 495, 546);
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/adminLogin.fxml", back, "Book", 600, 400);
    }
}
