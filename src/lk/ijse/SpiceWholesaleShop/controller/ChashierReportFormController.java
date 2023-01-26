package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class ChashierReportFormController {
    public AnchorPane ChashierReports;

    public void btnMonthlyIncome(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierReports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnBack(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierReports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnMostMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERMOSTMOVABLE,ChashierReports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLeastMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERLEASTMOVABLE,ChashierReports);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
