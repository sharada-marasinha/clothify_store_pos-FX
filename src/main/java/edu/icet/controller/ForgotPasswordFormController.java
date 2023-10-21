package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.utill.CrudUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;


public class ForgotPasswordFormController implements Initializable {


    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPassword;
    public JFXTextField txtEmail;
    public JFXTextField txtOtp;
    public JFXButton btnSaved;
    public JFXButton btnOk;

    StringProperty variable = new SimpleStringProperty("");
    StringProperty variable2 = new SimpleStringProperty("");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtPassword.textProperty().bindBidirectional(variable);
        txtConfirmPassword.textProperty().bindBidirectional(variable2);
        AtomicReference<String> val1 = new AtomicReference<>("");
        AtomicReference<String> val2 = new AtomicReference<>("");
        variable.addListener((observable, oldValue, newValue) -> {
            val1.set(newValue);
            conformPassword(val1, val2);
        });
        variable2.addListener((observable, oldValue, newValue) -> {
            val2.set(newValue);
            conformPassword(val1, val2);
        });

    }

    public void conformPassword(AtomicReference<String> newValueTxt1, AtomicReference<String> newValueTxt2) {
        if (txtPassword.getText().equals("") && txtConfirmPassword.getText().equals("")) {
            btnSaved.setDisable(true);
        } else if (newValueTxt1.get().equals(newValueTxt2.get())) {
            btnSaved.setDisable(false);
        } else {
            btnSaved.setDisable(true);
        }
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

    public void btnSentOtpOnAction(ActionEvent actionEvent) {
        if (!txtEmail.getText().equals("")) {
            sendEmail();
        }
    }

    char[] otp;

    public void btnOkOtpOnAction(ActionEvent actionEvent) {
        String OTP = "";
        for (char s : otp) {
            OTP += s;
        }
        if (txtOtp.getText().equals(OTP)) {
            new Alert(Alert.AlertType.INFORMATION, "OTP Matched :)").show();
            txtPassword.setDisable(false);
            txtConfirmPassword.setDisable(false);


        } else {
            txtPassword.setDisable(true);
            txtConfirmPassword.setDisable(true);
            btnSaved.setDisable(true);
            new Alert(Alert.AlertType.ERROR, "invalid OTP :(").show();
        }
    }

    public char[] getOtp(int len) {
        String numbers = "0123456789";
        Random rNd = new Random();
        char[] otp = new char[len];
        for (int i = 0; i < len; i++) {
            otp[i] = numbers.charAt(rNd.nextInt(numbers.length()));

        }
        return otp;
    }


    public void sendEmail() {
        String sender = "sharadamarasinha@gmail.com";
        String recipient = txtEmail.getText();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM user\n" +
                    "WHERE email = ?;", recipient);
            if (resultSet.next()) {
                otp = getOtp(6);
                String pw = "nixo ubxy urmo pmkh";

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(sender, pw);
                            }
                        }
                );

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(sender));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                    message.setSubject("change your password For this is OTP mail");
                    message.setText(Arrays.toString(otp) + " is your authentication setup code. \n\n hotline : +94779911825");
                    Transport.send(message);
                    new Alert(Alert.AlertType.INFORMATION, "otp has been send please check your email !").show();
                    txtOtp.setDisable(false);
                    btnOk.setDisable(false);

                } catch (MessagingException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }

            } else {
                new Alert(Alert.AlertType.ERROR, "Email not found !").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnSavedOnAction(ActionEvent actionEvent) {
        try {
           boolean isUpdate= CrudUtil.execute("UPDATE user\n" +
                    "SET password = ?\n" +
                    "WHERE email = ?;",txtConfirmPassword.getText(),txtEmail.getText());
           if (isUpdate){
               new Alert(Alert.AlertType.INFORMATION, "Your password change Success !").show();
           }else {
               new Alert(Alert.AlertType.ERROR, "Your password change Failed !").show();

           }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
