package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class AdminReportFormController {
    public AnchorPane Reports;
    public TableView tblMonthlySales;
    public TableColumn colOrderId;
    public TableColumn colCustomerId;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotalAmount;
    public TableColumn Discount;
    public TableColumn colDate;

    public void btnMonthlyIncome(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Reports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnBack(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Reports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnMostMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINMOSTMOVABLE,Reports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLeastMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINLEASTMOVABLE,Reports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
