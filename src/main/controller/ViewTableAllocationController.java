package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.model.CovidConditionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewTableAllocationController implements Initializable {
    SwitchSceneController ssc = new SwitchSceneController();
    CovidConditionModel ccm = new CovidConditionModel();
    @FXML private Button back;
    @FXML private Rectangle table1, table2, table3, table4, table5, table6, table7, table8, table9, table10,
            table11, table12, table13, table14, table15, table16;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Rectangle[]tables = {table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13,
                table14, table15, table16};

        try {
            ArrayList<Integer> tablesLocked = ccm.lockedTables();

            for(int i : tablesLocked){
                tables[i -1].setFill(Color.ORANGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void previousPage(ActionEvent event)throws SQLException {
        ssc.switchScene(event, "../view/GenerateReports.fxml", back, "Book", 600, 400);
    }
}
