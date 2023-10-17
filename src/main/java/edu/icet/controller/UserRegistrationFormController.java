package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.utill.CrudUtil;
import edu.icet.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserRegistrationFormController implements Initializable {
    public JFXTextField txtAdminUserName;
    public JFXTextField txtOtp;
    public JFXTextField txtUserName;
    public JFXComboBox redUserType;
    public JFXTextField txtEmail;
    public JFXPasswordField txtAdminPassword;
    public JFXPasswordField txtUserPassword;
    public JFXPasswordField txtConformUserPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        redUserType.getItems().addAll("Admin", "User");

    }

    public void backBtnOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            // Get the current window
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            // Close the previous window
            currentStage.close();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAdminCheckOnAction(ActionEvent actionEvent) {
    }

    public void btnCreateOnAction(ActionEvent actionEvent) {
        String useType =redUserType.getSelectionModel().getSelectedItem().toString();
        System.out.println(useType);


        String SQL = "INSERT INTO User (user_name, email, password, user_type) VALUES (?, ?, ?, ?)";
        try {
            CrudUtil.execute(SQL,txtUserName.getText(),txtEmail.getText(),txtUserPassword.getText(),useType);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
