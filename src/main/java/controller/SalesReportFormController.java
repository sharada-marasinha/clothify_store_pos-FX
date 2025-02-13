package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class SalesReportFormController {
    public AnchorPane LodeFormContent;

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/dash_bord_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.LodeFormContent.getChildren().clear();
        this.LodeFormContent.getChildren().add(load);
    }





    public void btnDailyReportOnAction(ActionEvent actionEvent) {
        try {
            JasperDesign load = JRXmlLoader.load("src/main/resources/report/Clothfy.jrxml");

//            JRDesignQuery jrDesignQuery = new JRDesignQuery();
//            jrDesignQuery.setText("SELECT * FROM employee WHERE empid=1");
//            load.setQuery(jrDesignQuery);

            JasperReport jasperReport = JasperCompileManager.compileReport(load);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperExportManager.exportReportToPdfFile(jasperPrint,"customer_2.pdf");
            JasperViewer.viewReport(jasperPrint,false);


        } catch (JRException | SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
