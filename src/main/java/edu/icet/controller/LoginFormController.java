package edu.icet.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.entity.User;
import edu.icet.utill.CrudUtil;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    public void btnLoginOnAction(ActionEvent actionEvent) {
        User user = getLogInUser();
        if (user!=null){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dash_bord_form.fxml"));
              // fxmlLoader.setControllerFactory(controllerClass -> new DashBordFormController(user));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                // Get the current window
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                // Close the previous window
                currentStage.close();
                stage.setResizable(false);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Your Password or Email incorrect try again!").show();
        }


    }

    public  User getLogInUser(){
        try {
            ResultSet rst= CrudUtil.execute("SELECT * FROM user\n" +
                    "WHERE email = ? AND password = ? AND (user_type = 'admin' OR user_type = 'user');",txtEmail.getText(),txtPassword.getText());
            while (rst.next()){
                return new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void lblMouseClickOnAction(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/forgot_password_form.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            // Get the current window
            Stage currentStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            // Close the previous window
            currentStage.close();
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lblRegisterMouseClickOnAction(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/user_registration_form.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            // Get the current window
            Stage currentStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            // Close the previous window
            currentStage.close();
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
