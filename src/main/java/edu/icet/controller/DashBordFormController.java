package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBordFormController implements Initializable {
    public AnchorPane LodeFormContent;
    public JFXButton btnReport;

    User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (user.getUser_type().equals("User")) {
            btnReport.setDisable(true);
            System.out.println(user);
        } else {
            btnReport.setDisable(false);
        }
    }

    DashBordFormController(User user) {
        this.user = user;

        System.out.println(user);
    }

    public void btnOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/place_order_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }


    public void logOutBtnOnAction(ActionEvent actionEvent) {
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

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/add_items_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/employee_registration_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/suppliers_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnOrderDetailsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/order_details_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnSalesReturnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/sales_return_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnReportsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/sales_report_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }


}
