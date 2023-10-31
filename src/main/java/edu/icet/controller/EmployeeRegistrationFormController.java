package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.EmployeeDao;
import edu.icet.dto.EmployeeDto;
import edu.icet.dto.tm.EmployeeTM;
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
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeRegistrationFormController implements Initializable {
    public AnchorPane LodeFormContent;
    public JFXTextField txtEmpId;
    public JFXTextField txtEmpName;
    public JFXTextField txtEmpNic;
    public JFXTextField txtEmpAddress;
    public TableView <EmployeeTM> empTable;
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

    EmployeeDao employeeDao = DaoFactory.getDaoFactory().getDaoType(DaoFactory.DaoType.EMPLOYEE);

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
        EmployeeDto employee=new EmployeeDto(
                cmbTitle.getSelectionModel().getSelectedItem().toString(),
                txtEmpName.getText(),
                txtEmpNic.getText(),
                dEmpDate.getValue().toString(),
                txtEmpAddress.getText(),
                txtEmpContact.getText(),
                txtEmpBankAcc.getText(),
                txtEmpBankBranch.getText()
        );
        try {
            boolean isAdd = employeeDao.save(employee);
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

        try {
            ObservableList <EmployeeTM> all = employeeDao.findAll();

            empTable.setItems(all);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }


}
