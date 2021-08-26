/*
 * Class: LoginController.java
 *
 * Description: The LoginController class will handle text boxes and buttons so that
 *              the user will be able to login successfully if the LoginModel authentication
 *              is successful.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.CurrentUserLoginDetailsModel;
import main.model.LoginModel;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Hyperlink forgotPassword;
    @FXML
    private Hyperlink registration;
    @FXML
    private Button login;

    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }
    /* login Action method
       check if user input is the same as database.
     */
    public void Login(ActionEvent event) throws IOException{
        Scene scene = login.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())){
                isConnected.setText("Logged in successfully");

                if(loginModel.isAdmin(txtUsername.getText()) == false){
                    CurrentUserLoginDetailsModel.setEmployeeID(loginModel.getid(txtUsername.getText()));
                    CurrentUserLoginDetailsModel.setFullName(loginModel.getFullName(txtUsername.getText()));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employeeLogin.fxml"));
                    Parent root = loader.load();
                    primaryStage.setTitle("Menu(Employee)");
                    primaryStage.setScene(new Scene(root, 600, 400));

                }else{
                    CurrentUserLoginDetailsModel.setEmployeeID(loginModel.getid(txtUsername.getText()));
                    CurrentUserLoginDetailsModel.setFullName(loginModel.getFullName(txtUsername.getText()));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/adminLogin.fxml"));
                    Parent root = loader.load();
                    primaryStage.setTitle("Menu(Admin)");
                    primaryStage.setScene(new Scene(root, 600, 400));

                }

            }else{
                isConnected.setText("username and password is incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //11.2.3 big sur

    public void resetPassword(ActionEvent event){
        // get the current scene from the button
        Scene scene = forgotPassword.getScene();
        // from the scene, we try to access the primary stage
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        // load the second scene
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/passwordReset.fxml"));
            primaryStage.setTitle("Reset Password");
            primaryStage.setScene(new Scene(root, 600, 450));
        } catch (IOException e) {
            System.out.println("Unable to register");
        }
    }

    public void register(){
        Scene scene = registration.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try{
            Parent root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
            primaryStage.setTitle("Register");
            primaryStage.setScene(new Scene(root, 400, 550));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
