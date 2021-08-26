/*
 * Class: RegisterController.java
 *
 * Description: The RegisterController class handles text fields and radio buttons
 *              so that required data can be retrieved for user registration.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.RegisterModel;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    RegisterModel rm = new RegisterModel();
    @FXML private ChoiceBox<String>choiceBox;
    @FXML private Label generatedID;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField answer;
    @FXML private ToggleGroup role;
    @FXML private RadioButton employeeRB, adminRB;
    @FXML private Button registerButton;
    @FXML private Button back;
    @FXML private Label warningLabel;
    private String type = "";
    private String selectedQuestion = "";
    private String[]secretQuestions = {"In what town or city did your parents meet?", "What was your childhood nickname? ", "What is the name of your favorite childhood friend? "};
    private int empID;
    private String emp_id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(secretQuestions);
        choiceBox.setOnAction(this::getChoiceBoxValue); //reference method operator --> ::
        try {
            this.empID = rm.generateEmployeeID();
            this.emp_id = String.format("%d", empID);
            generatedID.setText(emp_id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getChoiceBoxValue(ActionEvent event){
        String userSelected = choiceBox.getValue();
        selectedQuestion = userSelected;
    }

    public void getRole(ActionEvent event){
        if(employeeRB.isSelected()){
            type = "employee";
        }else if(adminRB.isSelected()){
            type = "admin";
        }
    }

    public void backToLogin(ActionEvent event){
        SwitchSceneController rtlc = new SwitchSceneController();
        rtlc.returnToLogin(event, back);
    }

    public void register(ActionEvent event) throws SQLException {
        Scene scene = registerButton.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() ||
                answer.getText().isEmpty() || selectedQuestion.isEmpty() || type.isEmpty()){
                warningLabel.setText("All textfields and choices must filled");
            }else {
                rm.createNewUser(empID, firstName.getText(), lastName.getText(), type, username.getText(), password.getText(), selectedQuestion, answer.getText());
                rm.addUserToWhitelist(empID);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/registrationSuccessful.fxml"));
                Parent root = loader.load();
                primaryStage.setTitle("Register");
                primaryStage.setScene(new Scene(root, 600, 400));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
