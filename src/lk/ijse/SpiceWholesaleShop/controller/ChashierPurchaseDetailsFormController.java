package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class ChashierPurchaseDetailsFormController {
    public AnchorPane ChashierPurchaseDetails;

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPRODUCT,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }


    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPURCHASE,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }


    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDER,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomer(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERCUSTOMER,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIEREMPLOYEES,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnpayment(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERBILL,ChashierPurchaseDetails);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
