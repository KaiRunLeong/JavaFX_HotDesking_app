/*
 * Class: ManageEmployeeController.java
 *
 * Description: The ManageEmployeeController class will communicate with the manageEmployee.fxml
 *              view to ensure that the admin will be able to manage their employee's details
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import main.model.ManageEmployeeModel;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageEmployeeController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    ManageEmployeeModel mem = new ManageEmployeeModel();
    @FXML private ChoiceBox<String> choiceBox;
    @FXML private TextField empID;
    @FXML private TextField empFirstName;
    @FXML private TextField empLastName;
    @FXML private TextField empUsername;
    @FXML private Hyperlink registerButton;
    @FXML private Button updateEmployeeButton;
    @FXML private Button back;
    @FXML private Label warning;
    int employeeID;
    public String[]intentions = {"Update Account", "Delete Account"};
    public String selectedIntention = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(intentions);
        choiceBox.setOnAction(this::getChoiceBoxValue); //reference method operator --> ::
    }

    public void getChoiceBoxValue(ActionEvent event){
        selectedIntention = choiceBox.getValue();
    }

    public void register(ActionEvent event){
        ssc.switchScene(event, "../view/register.fxml", registerButton, "Register", 400, 550);
    }

    public void updateEmployee(ActionEvent event){
        try {
            if(empID.getText().isEmpty()){
                warning.setText("Fill up employee id text field!");
            }else if (selectedIntention.equals(intentions[1]) && empID.getText().isEmpty() == false && isNumber(empID.getText())) {
                employeeID = Integer.parseInt(empID.getText());
                mem.deleteAccount(employeeID);
                ssc.switchScene(event, "../view/accountDeleted.fxml", updateEmployeeButton, "Manage Account");
            }else if (selectedIntention.equals(intentions[0]) && empID.getText().isEmpty() == false && isNumber(empID.getText())){
                employeeID = Integer.parseInt(empID.getText());
                String firstName = empFirstName.getText();
                String lastName = empLastName.getText();
                String username = empUsername.getText();
                String[]emptyDictionary = {firstName, lastName, username};
                int i = 0;

                for(String str : emptyDictionary){
                    if(str.isEmpty() == false && i == 0){
                        mem.updateFirstName(str, employeeID);
                    }else if(str.isEmpty() == false && i == 1){
                        mem.updateLastName(str, employeeID);
                    }else if(str.isEmpty() == false && i == 2){
                        mem.updateUsername(str, employeeID);
                    }
                    i++;
                }
                ssc.switchScene(event, "../view/employeeUpdated.fxml", updateEmployeeButton, "Manage Employee");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/adminLogin.fxml", back, "Menu(Employee)", 600, 400);
    }

    public static boolean isNumber(String number){
        boolean result = true;
        boolean isNumeric;

        for(int i = 0; i < number.length(); i++){
            isNumeric = Character.isDigit(number.charAt(i));
            if(isNumeric == false){
                result = false;
                break;
            }
        }

        return result;
    }

}
