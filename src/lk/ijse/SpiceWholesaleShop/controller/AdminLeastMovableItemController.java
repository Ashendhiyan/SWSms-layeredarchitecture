package lk.ijse.SpiceWholesaleShop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;

public class AdminLeastMovableItemController {
    public AnchorPane Least;

    public void btnMonthlyIncome(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Least);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnMostMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINMOSTMOVABLE,Least);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLeastMovable(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINLEASTMOVABLE,Least);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnBack(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Least);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
}
