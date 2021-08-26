/*
 * Class: PasswordResetController.java
 *
 * Description: The PasswordResetController class will handle text fields to
 *              ensure that required data are needed for a password reset
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Button;
import main.model.PasswordResetModel;
import java.io.IOException;

public class PasswordResetController{
    public PasswordResetModel prm = new PasswordResetModel();
    @FXML private TextField username;
    @FXML private TextField newPassword;
    @FXML private TextField reenterPass;
    @FXML private Button nextButton;
    @FXML private Button back;
    @FXML private Label invalidUser;
    @FXML private Label passwordNotMatch;

    public void next(ActionEvent event){
        Scene scene = nextButton.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            if(prm.checkValidUser(username.getText()) && (newPassword.getText().isEmpty() || reenterPass.getText().isEmpty())) {
                passwordNotMatch.setText("Password not filled");
            }else if (prm.checkValidUser(username.getText()) && newPassword.getText().equals(reenterPass.getText())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/securityQuestion.fxml"));
                Parent root = loader.load();
                SecurityQuestionController sqc = loader.getController();
                sqc.securityQuestionLabel(prm.getSecurityQuestion(username.getText()));
                sqc.getUsernamePassword(username.getText(), reenterPass.getText());
                primaryStage.setTitle("Reset Password");
                primaryStage.setScene(new Scene(root, 600, 450));

            }else if(prm.checkValidUser(username.getText()) == false){
                invalidUser.setText("Invalid username");
            }else if(!newPassword.getText().equals(reenterPass.getText())){
                passwordNotMatch.setText("Password does not match");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void returnToPreviousPage(ActionEvent event){
        Scene scene = back.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
            primaryStage.setTitle("Reset Password");
            primaryStage.setScene(new Scene(root, 400, 400));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
