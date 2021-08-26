/*
 * Class: ViewDeskDetailsController.java
 *
 * Description: The ViewDeskDetailsController class will set the status label.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import main.model.ViewDeskDetailsModel;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewDeskDetailsController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    ViewDeskDetailsModel vddm = new ViewDeskDetailsModel();
    @FXML private Button normalButton;
    @FXML private Button covidConditionButton;
    @FXML private Button lockdownButton;
    @FXML private Button back;
    @FXML private Label status;


    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            if (vddm.isUnderCovidCondition()) {
                status.setText("Covid Condition");
            }else{
                status.setText("Normal");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void normal(ActionEvent event){
        try {
            vddm.setToNormal();
            status.setText("Normal");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void covidCondition(ActionEvent event){
        ssc.switchScene(event, "../view/covidCondition.fxml", covidConditionButton, "COVID Condition", 495, 546);

    }

    public void lockdown(ActionEvent event){
        try {
            vddm.setToLockDown();
            status.setText("Lockdown");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/adminLogin.fxml", back, "Menu(Admin)", 600, 400);
    }
}
