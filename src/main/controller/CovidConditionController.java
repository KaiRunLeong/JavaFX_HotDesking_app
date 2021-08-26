/*
 * Class: CovidConditionController.java
 *
 * Description: The CovidConditionController class will contain a total of 17 buttons, 16 of those
 *              buttons will handle the booking of a table.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import main.model.CovidConditionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CovidConditionController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    CovidConditionModel ccm = new CovidConditionModel();
    @FXML private Button table1;
    @FXML private Button table2;
    @FXML private Button table3;
    @FXML private Button table4;
    @FXML private Button table5;
    @FXML private Button table6;
    @FXML private Button table7;
    @FXML private Button table8;
    @FXML private Button table9;
    @FXML private Button table10;
    @FXML private Button table11;
    @FXML private Button table12;
    @FXML private Button table13;
    @FXML private Button table14;
    @FXML private Button table15;
    @FXML private Button table16;
    @FXML private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Button[]tables = {table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13,
                table14, table15, table16};

        try {
            ArrayList<Integer> tablesLocked = ccm.lockedTables();

            for(int i : tablesLocked){
                tables[i -1].setStyle("-fx-background-color: #ffa01f");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void switchStatus(int tableNum, Button table) throws SQLException{
        if(ccm.isLocked(tableNum)){
            ccm.setToAvailable(tableNum);
            table.setStyle("-fx-background-color: #0bd354");
        }else{
            ccm.setToCovidCondition(tableNum);
            table.setStyle("-fx-background-color: #ffa01f");
        }
    }

    public void tableOne(ActionEvent event) throws SQLException {
        switchStatus(1, table1);

    }

    public void tableTwo(ActionEvent event) throws SQLException{
        switchStatus(2, table2);
    }

    public void tableThree(ActionEvent event)throws SQLException{
        switchStatus(3, table3);
    }

    public void tableFour(ActionEvent event)throws SQLException{
        switchStatus(4, table4);
    }

    public void tableFive(ActionEvent event)throws SQLException{
        switchStatus(5, table5);
    }

    public void tableSix(ActionEvent event)throws SQLException{
        switchStatus(6, table6);
    }

    public void tableSeven(ActionEvent event)throws SQLException{
        switchStatus(7, table7);
    }

    public void tableEight(ActionEvent event)throws SQLException{
        switchStatus(8, table8);
    }

    public void tableNine(ActionEvent event)throws SQLException{
        switchStatus(9, table9);
    }

    public void tableTen(ActionEvent event)throws SQLException{
        switchStatus(10, table10);
    }

    public void tableEleven(ActionEvent event) throws SQLException{
        switchStatus(11, table11);
    }

    public void tableTwelve(ActionEvent event)throws SQLException{
        switchStatus(12, table12);
    }

    public void tableThirteen(ActionEvent event)throws SQLException{
        switchStatus(13, table13);
    }

    public void tableFourteen(ActionEvent event)throws SQLException{
        switchStatus(14, table14);
    }

    public void tableFifteen(ActionEvent event)throws SQLException{
        switchStatus(15, table15);
    }

    public void tableSixteen(ActionEvent event)throws SQLException{
        switchStatus(16, table16);
    }

    public void previousPage(ActionEvent event)throws SQLException{
        ssc.switchScene(event, "../view/viewDeskDetails.fxml", back, "Book", 500, 400);
    }
}
