package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class AdminOrderDetailsFormController {
    public AnchorPane OrderDetails;
    public AnchorPane AdminPurchaseDetails;
    public AnchorPane ChashierPurchaseDetails;

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,OrderDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
