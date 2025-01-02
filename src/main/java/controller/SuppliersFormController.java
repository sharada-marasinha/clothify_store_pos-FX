package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Supplier;
import utill.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SuppliersFormController implements Initializable {
    public AnchorPane LodeFormContent;
    public JFXTextField txtSupId;
    public JFXTextField txtSupContact;
    public JFXTextField txtSupCompany;
    public TableView supTable;
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colCompany;
    public TableColumn colContact;
    public TableColumn colOption;
    public JFXComboBox cmbSubTitle;
    public JFXTextField txtSupName;
    public JFXTextField txtSupMail;
    public TableView supItemTable;
    public TableColumn colItemCode;
    public TableColumn colDesc;
    public TableColumn colQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("option"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        loadTable();
        cmbSubTitle.getItems().addAll("Mr","Ms","Mrs");
        loadTable();
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/dash_bord_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            boolean isAdd = CrudUtil.execute("INSERT INTO Supplier (title, supplierName, contact, company, email)\n" +
                    "VALUES (?,?,?,?,?)",
                    cmbSubTitle.getSelectionModel().getSelectedItem().toString(),
                    txtSupName.getText(),
                    txtSupContact.getText(),
                    txtSupCompany.getText(),
                    txtSupMail.getText()
            );
            if (isAdd){
                new Alert(Alert.AlertType.INFORMATION,"Supplier Registration Successfully !").show();
                loadTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong !").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void loadTable(){
        ObservableList<Supplier> list = FXCollections.observableArrayList();
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM supplier");
            while (rst.next()) {

                list.add(new Supplier(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6)
                ));
            }

            supTable.setItems(list);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
