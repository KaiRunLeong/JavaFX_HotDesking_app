/*
 * Class: SecurityQuestionController.java
 *
 * Description: The SecurityQuestionController class will instantiate the SecurityQuestionModel
 *              class to determine if the entered answer is correct.
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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.SecurityQuestionModel;

public class SecurityQuestionController {
    public SecurityQuestionModel sqm = new SecurityQuestionModel();
    private String username = "";
    private String password = "";
    @FXML private Button resetPassword;
    @FXML private Label securityQuestion;
    @FXML private TextField answer;
    @FXML private Label invalidAnswer;


    public void securityQuestionLabel(String text){
        securityQuestion.setText(text);
    }

    public void getUsernamePassword(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public void reset(){
        Scene scene = resetPassword.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            if (sqm.checkAnswer(username, answer.getText())) {
                sqm.changePassword(username, password);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/resetPasswordSuccessful.fxml"));
                Parent root = loader.load();
                primaryStage.setTitle("Reset Password");
                primaryStage.setScene(new Scene(root, 600, 450));
            } else {
                invalidAnswer.setText("Answer is incorrect");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
