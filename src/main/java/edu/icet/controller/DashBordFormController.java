package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.entity.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBordFormController implements Initializable {
    public AnchorPane LodeFormContent;
    public JFXButton btnReport;
    public Label lblUserName;
    public Label lblUserAType;
    public Label lblUserEmail;
    public Label lblDate;
    public Label lblTime;

    User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDateAndTime();
//        lblUserEmail.setText(user.getEmail());
//        lblUserName.setText("Hello' "+user.getUser_name());
//        lblUserAType.setText(user.getUser_type());
//        if (user.getUser_type().equals("Admin")) {
//            btnReport.setDisable(false);
//            System.out.println(user);
//        }
    }
//    DashBordFormController(){}
//    DashBordFormController(User user) {
//        this.user = user;
//
//        System.out.println(user);
//    }

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
    Date date;
    private void loadDateAndTime() {
        date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime cTime = LocalTime.now();
            lblTime.setText(
                    cTime.getHour() + ":" + cTime.getMinute() + ":" + cTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

    }



}
