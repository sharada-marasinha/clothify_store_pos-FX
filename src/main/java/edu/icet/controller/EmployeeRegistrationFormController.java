package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.entity.Employee;
import edu.icet.utill.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeRegistrationFormController implements Initializable {
    public AnchorPane LodeFormContent;
    public JFXTextField txtEmpId;
    public JFXTextField txtEmpName;
    public JFXTextField txtEmpNic;
    public JFXTextField txtEmpAddress;
    public TableView empTable;
    public TableColumn empColId;
    public TableColumn empColName;
    public TableColumn empColNic;
    public TableColumn empColAddress;
    public TableColumn empColDob;
    public TableColumn empColContact;
    public TableColumn empColBAccNo;
    public TableColumn empColBankBranch;
    public JFXTextField txtEmpContact;
    public JFXTextField txtEmpBankAcc;
    public JFXTextField txtEmpBankBranch;
    public DatePicker dEmpDate;
    public ComboBox cmbTitle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            empColId.setCellValueFactory(new PropertyValueFactory<>("empId"));
            empColName.setCellValueFactory(new PropertyValueFactory<>("name"));
            empColNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
            empColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            empColDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            empColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            empColBAccNo.setCellValueFactory(new PropertyValueFactory<>("bankAccountNo"));
            empColBankBranch.setCellValueFactory(new PropertyValueFactory<>("bankBranch"));
            cmbTitle.getItems().addAll("Mr","Ms","Mrs");
        loadTable();
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/dash_bord_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnSaveOnAction(ActionEvent actionEvent){
        try {
            boolean isAdd = CrudUtil.execute("INSERT INTO Employer (title, name, nic, dateOfBirth, address, contactNo, bankAccNo, bankBranch)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    cmbTitle.getSelectionModel().getSelectedItem().toString(),
                    txtEmpName.getText(),
                    txtEmpNic.getText(),
                    dEmpDate.getValue().toString(),
                    txtEmpAddress.getText(),
                    txtEmpContact.getText(),
                    txtEmpBankAcc.getText(),
                    txtEmpBankBranch.getText()
                    );
            if (isAdd){
                new Alert(Alert.AlertType.INFORMATION,"Employer Add Successfully !").show();
                loadTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong !").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void loadTable(){
        ObservableList<Employee> list = FXCollections.observableArrayList();
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM Employer");
            while (rst.next()) {

                list.add(new Employee(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8),
                        rst.getString(9)
                ));
            }

            empTable.setItems(list);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
