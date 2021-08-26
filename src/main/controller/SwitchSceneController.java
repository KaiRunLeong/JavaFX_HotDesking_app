/*
 * Class: SwitchSceneController.java
 *
 * Description: This class will be used to switch scenes easily with the use of
 *              the switchScene() method. However, an instance of this class has
 *              to be instantiated first before calling the method.
 *
 * Author: Kai Run Leong (S3862092)
 */

package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SwitchSceneController {

    public void returnToLogin(ActionEvent event, Button loginButton){
        try {
            Scene scene = loginButton.getScene();
            Window window = scene.getWindow();
            Stage primaryStage = (Stage) window;
            primaryStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * Description: This method can be used after class instantiation to switch between
     *              scenes easily. However, to set a specific dimension to the scene it's override
     *              method should be called instead.
     */
    public void switchScene(ActionEvent event, String viewPath, Button button, String title){
        Scene scene = button.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Parent root = loader.load();
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, 600, 500));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchScene(ActionEvent event, String viewPath, Button button, String title, int width, int height){
        Scene scene = button.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Parent root = loader.load();
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, width, height));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchScene(ActionEvent event, String viewPath, Hyperlink hyperlink, String title, int width, int height){
        Scene scene = hyperlink.getScene();
        Window window = scene.getWindow();
        Stage primaryStage = (Stage) window;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Parent root = loader.load();
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, width, height));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
