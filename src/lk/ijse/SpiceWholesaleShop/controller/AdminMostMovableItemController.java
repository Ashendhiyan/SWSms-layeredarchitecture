package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class AdminMostMovableItemController {
    public AnchorPane Most;

    public void btnMonthlyIncome(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Most);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }


    public void btnBack(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Most);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnMostMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINMOSTMOVABLE,Most);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLeastMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINLEASTMOVABLE,Most);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
