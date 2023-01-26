package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class ChashierLeastMovableItemController {
    public AnchorPane ChashierLeast;
    public void btnMonthlyIncome(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierLeast);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnMostMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERMOSTMOVABLE,ChashierLeast);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLeastMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERLEASTMOVABLE,ChashierLeast);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnBack(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierLeast);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
