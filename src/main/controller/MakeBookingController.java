/*
 * Class: MakeBookingController.java
 *
 * Description: The MakeBookingController class will handle date pickers and
 *              radio button so that the user will be able to select a time
 *              slot and a date for booking.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MakeBookingController {
    SwitchSceneController ssc = new SwitchSceneController();
    @FXML private Button back;
    @FXML private Button nextButton;
    @FXML private DatePicker datePicker;
    @FXML private RadioButton button1;
    @FXML private RadioButton button2;
    @FXML private RadioButton button3;
    @FXML private RadioButton button4;
    @FXML private RadioButton button5;
    private String date;
    private String time;

    public void getDate(){
        this.date = datePicker.getValue().toString();
    }

    public void getTime(){
        if(button1.isSelected()){
            time = "08:30 - 10:30";
        }else if(button2.isSelected()){
            time = "10:30 - 12:30";
        }else if(button3.isSelected()){
            time = "12:30 - 13:30";
        }else if(button4.isSelected()){
            time = "13:30 - 15:30";
        }else if(button5.isSelected()){
            time = "15:30 - 17:30";
        }
    }


    public void next(ActionEvent event) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date chosenDate = dateFormat.parse(date);
        Date currentDate = new Date();
        currentDate = dateFormat.parse(simpleDateFormat.format(currentDate));

        if(chosenDate.compareTo(currentDate) > 0){
            BookATableController.date = date;
            BookATableController.time = time;
            ssc.switchScene(event, "../view/bookATable.fxml", nextButton, "Book", 495, 546);
        }


    }

    public void previousPage(ActionEvent event){
        try {
            ssc.switchScene(event, "../view/book.fxml", back, "Book", 600, 400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
