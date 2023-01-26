package lk.ijse.SpiceWholesaleShop.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {

            case DASHBOARD:
                window.setTitle("Dashboard");
                window.setResizable(false);
                initUI("DashboardView.fxml");
                break;
            case CUSTOMER:
                window.setTitle("Customer");
                window.setResizable(false);
                initUI("AdminCustomerForm.fxml");
                break;
            case BILL:
                window.setTitle("BillView");
                window.setResizable(false);
                initUI("AdminBillViewForm.fxml");
                break;
            case CHASHIERBILL:
                window.setTitle("BillView");
                window.setResizable(false);
                initUI("ChashierBillViewForm.fxml");
                break;
            case CASHIERDASH:
                window.setTitle("Cashier Dashboard");
                window.setResizable(false);
                initUI("CashierDashboardForm.fxml");
                break;
            case EMPLOYEES:
                window.setTitle("Employees");
                window.setResizable(false);
                initUI("AdminEmployeeForm.fxml");
                break;
            case CHASHIEREMPLOYEES:
                window.setTitle("Chashier Employees");
                window.setResizable(false);
                initUI("ChashierEmployeeForm.fxml");
                break;
            case ADMINLEASTMOVABLE:
                window.setTitle("Report");
                window.setResizable(false);
                initUI("AdminLeastMovableItem.fxml");
                break;
            case CHASHIERLEASTMOVABLE:LEASTMOVABLE:
                window.setTitle("Report");
                window.setResizable(false);
                initUI("ChashierLeastMovableItem.fxml");
                break;
            case LOGIN:
                window.setTitle("Login");
                window.setResizable(false);
                initUI("LoginForm.fxml");
                break;
            case ADMINMOSTMOVABLE:
                window.setTitle("Report");
                window.setResizable(false);
                initUI("AdminMostMovableItem.fxml");
                break;
            case CHASHIERMOSTMOVABLE:MOSTMOVABLE:
                window.setTitle("Report");
                window.setResizable(false);
                initUI("ChashierMostMovableItem.fxml");
                break;
            case ADMINORDERDETAILS:
                window.setTitle("Order Details");
                window.setResizable(false);
                initUI("AdminOrderDetailsForm.fxml");
                break;
            case CHASHIERORDERDETAILS:
                window.setTitle("Order Details");
                window.setResizable(false);
                initUI("ChashierOrderDetailsForm.fxml");
                break;
            case ADMINORDER:
                window.setTitle("Order ");
                window.setResizable(false);
                initUI("AdminOrderForm.fxml");
                break;
            case CHASHIERORDER:
                window.setTitle("Order ");
                window.setResizable(false);
                initUI("ChashierOrderForm.fxml");
                break;
            case ADMINPURCHASE:
                window.setTitle("Purchase ");
                window.setResizable(false);
                initUI("AdminPurchaseForm.fxml");
                break;
            case CHASHIERPURCHASE:
                window.setTitle("Purchase ");
                window.setResizable(false);
                initUI("ChashierPurchaseForm.fxml");
                break;
            case ADMINREPORT:
                window.setTitle("Report ");
                window.setResizable(false);
                initUI("AdminReportForm.fxml");
                break;
            case CHASHIERREPORT:
                window.setTitle("Report ");
                window.setResizable(false);
                initUI("ChashierReportForm.fxml");
                break;
            case ADMINPRODUCT:
                window.setTitle("Product ");
                window.setResizable(false);
                initUI("AdminSpiceForm.fxml");
                break;
            case CHASHIERPRODUCT:
                window.setTitle("Product ");
                window.setResizable(false);
                initUI("ChashierSpiceForm.fxml");
                break;
            case USER:
                window.setTitle("User ");
                window.setResizable(false);
                initUI("UserView.fxml");
                break;
            case CASHIERCUSTOMER:
                window.setTitle("Cashier Customer");
                window.setResizable(false);
                initUI("ChashierCustomerForm.fxml");
                break;
            case ADMINPURCHASEDETAILS:
                window.setTitle("Purchase Details");
                window.setResizable(false);
                initUI("AdminPurchaseDetailsForm.fxml");
                break;
            case CASHIERPURCHASEDETAILS:
                window.setTitle("Purchase Details");
                window.setResizable(false);
                initUI("ChashierPurchaseDetailsForm.fxml");
                break;


            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("../view/" + location)));
    }
}
