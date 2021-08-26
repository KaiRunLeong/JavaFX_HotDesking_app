/*
 * Class: BookATableController.java
 *
 * Description: The BookATableController class will call methods from the BookATableModel
 *              class to update the booking tables. Furthermore, this controller will communicate
 *              with the bookATable.fxml file
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.model.BookATableModel;
import java.util.ArrayList;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import main.model.CovidConditionModel;

public class BookATableController implements Initializable{
    SwitchSceneController ssc = new SwitchSceneController();
    BookATableModel btm = new BookATableModel();
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
    public static String date = ""; //static because initialize won't load information
    public static String time = "";

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Button[]tables = {table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13,
                table14, table15, table16};

        try {
            ArrayList<Integer> tablesBooked = btm.tablesBooked(date, time);

            for(int i : tablesBooked){
                tables[i -1].setStyle("-fx-background-color: #eb1919");
            }

            for(int i = 0; i < tables.length; i++){
                if(ccm.isLocked(i + 1)){
                    tables[i].setStyle("-fx-background-color: #ffa01f");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tableOne(ActionEvent event) throws SQLException {
        if(btm.whiteList() == 1) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(1) && btm.userAlreadyBooked() == false){
            btm.bookTableNow(1, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table1, "Book", 600, 400);
        }
    }

    public void tableTwo(ActionEvent event) throws SQLException{
        if(btm.whiteList() == 2) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(2) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(2, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table2, "Book", 600, 400);
        }
    }

    public void tableThree(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 3) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        } else if(btm.clickable(3) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(3, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table3, "Book", 600, 400);
        }
    }

    public void tableFour(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 4) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        } else if(btm.clickable(4) && btm.userAlreadyBooked() == false){
            btm.bookTableNow(4, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table4, "Book", 600, 400);
        }
    }

    public void tableFive(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 5) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(5) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(5, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table5, "Book", 600, 400);
        }
    }

    public void tableSix(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 6) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(6) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(6, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table6, "Book", 600, 400);
        }
    }

    public void tableSeven(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 7) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(7) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(7, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table7, "Book", 600, 400);
        }
    }

    public void tableEight(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 8) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(8) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(8, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table8, "Book", 600, 400);
        }
    }

    public void tableNine(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 9) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(9) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(9, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table9, "Book", 600, 400);
        }
    }

    public void tableTen(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 10) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(10) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(10, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table10, "Book", 600, 400);
        }
    }

    public void tableEleven(ActionEvent event) throws SQLException{
        if(btm.whiteList() == 11) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(11) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(11, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table11, "Book", 600, 400);
        }
    }

    public void tableTwelve(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 12) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        } else if(btm.clickable(12) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(12, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table12, "Book", 600, 400);
        }
    }

    public void tableThirteen(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 13) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(13) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(13, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table13, "Book", 600, 400);
        }
    }

    public void tableFourteen(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 14) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(15) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(14, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table14, "Book", 600, 400);
        }
    }

    public void tableFifteen(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 15) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(15) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(15, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table15, "Book", 600, 400);
        }
    }

    public void tableSixteen(ActionEvent event)throws SQLException{
        if(btm.whiteList() == 16) {
            ssc.switchScene(event, "../view/whiteListWarning.fxml", table1, "Book", 600, 400);
        }else if(btm.clickable(16) && btm.userAlreadyBooked() == false) {
            btm.bookTableNow(16, time, date);
            ssc.switchScene(event, "../view/bookingSuccessful.fxml", table16, "Book", 600, 400);
        }
    }

    public void previousPage(ActionEvent event)throws SQLException{
        ssc.switchScene(event, "../view/makeBooking.fxml", back, "Book", 453, 453);
    }

}