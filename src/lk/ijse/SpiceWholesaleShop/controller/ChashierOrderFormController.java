package lk.ijse.SpiceWholesaleShop.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.model.*;
import lk.ijse.SpiceWholesaleShop.to.*;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.tm.AddOrderTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class ChashierOrderFormController {
    public AnchorPane ChashierOrder;
    public ComboBox cmbItemCode;
    public Label lblDescription;
    public Label lblPurchasePrice;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public TextField txtQty;
    public TextField txtDiscount;
    public Label lblOrderId;
    public Label lblCustomerName;
    public ComboBox cmbItemCode1;
    public JFXDatePicker OrderDate;
    public TableView<AddOrderTm> tblAddOrder;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colAction;
    public Label lblOrderDate;
    public ComboBox cmbCustomerId;
    public TableColumn colPurchasePrice;
    private ObservableList<AddOrderTm> obList = FXCollections.observableArrayList();

    public void initialize(){
        loadOrderDate();
        LoadProductCode();
        loadNextOrderId();
        loadCustomerIds();
        setCellValueFactory();
    }

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPRODUCT,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIEREMPLOYEES,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPURCHASE,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDER,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomer(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERCUSTOMER,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnpayment(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERBILL,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrderDetails(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDERDETAILS,ChashierOrder);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    private void loadOrderDate() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }
    public void LoadProductCode(){
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = SpiceModel.loadItemCodes();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadNextOrderId() {
        try {
            String orderId = OrderModel.generateNextOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = CustomerModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillItemFields(Spice item) {
        lblDescription.setText(item.getDescription());
        lblPurchasePrice.setText(String.valueOf(item.getPurchasePrice()));
        lblUnitPrice.setText(String.valueOf(item.getUnitPrice()));
        lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
    }
    private void fillCustomerFields(Customer customer) {
        lblCustomerName.setText(customer.getName());
    }
    private void setCellValueFactory() {
        colProductCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPurchasePrice.setCellValueFactory(new PropertyValueFactory("PurchasePrice"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }
    public void cmbICustomerOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbCustomerId.getValue());
        try {
            Customer customer = CustomerModel.SearchId(code);
            fillCustomerFields(customer);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String orderId = lblOrderId.getText();
        String customerId = String.valueOf(cmbCustomerId.getValue());
        String description=lblDescription.getText();
        ArrayList<CartDetail> cartDetails = new ArrayList<>();

        /* load all cart items' to orderDetails arrayList */
        for (int i = 0; i < tblAddOrder.getItems().size(); i++) {
            /* get each row details to (PlaceOrderTm)lk.ijse.SpiceWholesaleShop.tm in each time and add them to the orderDetails */
            AddOrderTm tm = obList.get(i);
            cartDetails.add(new CartDetail(orderId, tm.getItemCode(),tm.getQty(), tm.getUnitPrice(),tm.getTotal()));
        }

        PlaceOrder placeOrder = new PlaceOrder(customerId, orderId,description ,cartDetails);
        try {
            boolean isPlaced = PlaceOrderModel.placeOrder(placeOrder);
            if (isPlaced) {
                /* to clear table */
                obList.clear();
                loadNextOrderId();
                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void cmbItemOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        try {
            Spice item = SpiceModel.SearchId(code);
            fillItemFields(item);
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(ActionEvent actionEvent) {
        String OrderId = lblOrderId.getText();
        String itemCode = String.valueOf(cmbItemCode.getValue());
        String desc = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double PurchasePrice = Double.parseDouble(lblPurchasePrice.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = unitPrice * qty;
        Button btnDelete = new Button("Delete");
        txtQty.setText("");


        if (!obList.isEmpty()) {
            L1:
            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblAddOrder.getItems().size(); i++) {
                if (colProductCode.getCellData(i).equals(itemCode)) {
                    qty += (int) colQty.getCellData(i);
                    total = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblAddOrder.refresh();
                    return;
                }
            }
        }
        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                System.out.println( colAction.getId());
               // colAction.getId();
                tblAddOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>(null));
                //AddOrderTm.SpiceWholesaleShop.tm = tblAddOrder.getSelectionModel().getSelectedItem();
                tblAddOrder.getItems().removeAll(tblAddOrder.getSelectionModel().getSelectedItem());
            }
        });
        obList.add(new AddOrderTm(itemCode, desc, qty,PurchasePrice, unitPrice, total, btnDelete));
        tblAddOrder.setItems(obList);
    }
}
