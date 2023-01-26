package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class ChashierBillViewFormController {
    public AnchorPane ChashierBill;
    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPRODUCT,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }


    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPURCHASE,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }


    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDER,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomer(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERCUSTOMER,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIEREMPLOYEES,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnpayment(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERBILL,ChashierBill);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
