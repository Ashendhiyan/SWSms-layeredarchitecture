package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class AdminPurchaseDetailsFormController {
    public AnchorPane AdminPurchaseDetails;
    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,AdminPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
