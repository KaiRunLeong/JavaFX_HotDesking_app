/*
 * Class: ManageAccountController.java
 *
 * Description: The ManageAccountController class will handle text boxes so that
 *              it will be able to refactor data that is already in the database.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import main.model.ManageAccountModel;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageAccountController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    ManageAccountModel mam = new ManageAccountModel();
    @FXML private ChoiceBox<String> choiceBox;
    @FXML public TextField empFirstName;
    @FXML public TextField empLastName;
    @FXML public TextField empUsername;
    @FXML private Button updateButton;
    @FXML private Button back;
    public String[]intentions = {"Update Account", "Delete Account"};
    public String selectedIntention = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(intentions);
        choiceBox.setOnAction(this::getChoiceBoxValue); //reference method operator --> ::
    }

    public void getChoiceBoxValue(ActionEvent event){
        String userSelected = choiceBox.getValue();
        selectedIntention = userSelected;
    }

    public void update(ActionEvent event){
        try {
            if (selectedIntention.equals(intentions[1])) {
                mam.deleteAccount();
                ssc.switchScene(event, "../view/accountDeleted.fxml", updateButton, "Manage Account", 600, 400);
            }else{
                String firstName = empFirstName.getText();
                String lastName = empLastName.getText();
                String username = empUsername.getText();
                String[]emptyDictionary = {firstName, lastName, username};
                int i = 0;

                for(String str : emptyDictionary){
                    if(str.isEmpty() == false && i == 0){
                        mam.updateFirstName(str);
                    }else if(str.isEmpty() == false && i == 1){
                        mam.updateLastName(str);
                    }else if(str.isEmpty() == false && i == 2){
                        mam.updateUsername(str);
                    }

                    i++;
                }
                ssc.switchScene(event, "../view/accountUpdated.fxml", updateButton, "Manage Account");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event){
        ssc.switchScene(event, "../view/employeeLogin.fxml", back, "Menu(Employee)", 600, 400);
    }

}
