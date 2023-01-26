package lk.ijse.SpiceWholesaleShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.model.CustomerModel;
import lk.ijse.SpiceWholesaleShop.to.Customer;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.util.Service;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChashierCustomerFormController {
    public AnchorPane ChashierCustomers;
    public TextField txtIdSearch;
    public TextField txtId;
    public TextField txtName;
    public TextField txtNic;
    public TextField txtEmail;
    public TextField txtTelNo;
    public TextField txtAddress;
    public TableView<Customer> tblCustomer;
    public TableColumn<Customer,String> colCustomerId;
    public TableColumn<Customer,String>  colName;
    public TableColumn<Customer,String>  colAddress;
    public TableColumn<Customer,String>  colTelNo;
    public TableColumn<Customer,String>  colEmail;
    public TableColumn<Customer,String>  colNic;
    public Button btnAddDisable;
    boolean isMatchTelNo=false;
    boolean isMatchCustomerID=false;
    boolean isMatchName=false;
    boolean isMatchAddress=false;
    boolean isMatchEmail=false;
    boolean isMatchNic=false;

    public void initialize(){
            loadTableData();
    }

    private void loadTableData() {
        refreshTableData();
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("telNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
    }
    private void refreshTableData() {
        try {
            ArrayList<Customer> customer=CustomerModel.getAllCustomer();
            ObservableList<Customer> CustomerObservableList= FXCollections.observableArrayList();
            CustomerObservableList.addAll(customer);
            tblCustomer.setItems(CustomerObservableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERDASH,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPRODUCT,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDER,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERCUSTOMER,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIEREMPLOYEES,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERPURCHASE,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERREPORT,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnpayment(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERBILL,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomer(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CASHIERCUSTOMER,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CHASHIERORDER,ChashierCustomers);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void idSearchOnAction(ActionEvent actionEvent) {
       btnSearch(actionEvent);
    }

    public void txtTelNoOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(txtTelNo.getText())){
            txtTelNo.setStyle("-fx-border-color: green");
            isMatchTelNo=true;
        }else {
            txtTelNo.setStyle("-fx-border-color: red");
            isMatchTelNo=false;
        }
    }
    public void txtIdOnAction(KeyEvent keyEvent) {
        if (Service.isValidCustomerId(txtId.getText())){
            txtId.setStyle("-fx-border-color: green");
            isMatchCustomerID=true;
        }else {
            txtId.setStyle("-fx-border-color: red");
            isMatchCustomerID=false;
        }
    }

    public void txtNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtName.getText())){
            txtName.setStyle("-fx-border-color: green");
            isMatchName=true;
        }else {
            txtName.setStyle("-fx-border-color: red");
            isMatchName=false;
        }
    }

    public void txtEmailOnAction(KeyEvent keyEvent) {
        if (Service.isValidEmail(txtEmail.getText())){
            txtEmail.setStyle("-fx-border-color: green");
            isMatchEmail=true;
        }else {
            txtEmail.setStyle("-fx-border-color: red");
            isMatchEmail=false;
        }
    }

    public void txtNicOnAction(KeyEvent keyEvent) {
        if (Service.isValidNic(txtNic.getText())){
            txtNic.setStyle("-fx-border-color: green");
            isMatchNic=true;
        }else {
            txtNic.setStyle("-fx-border-color: red");
            isMatchNic=false;
        }
    }

    public void txtAddress(KeyEvent keyEvent) {
        if (Service.isValidName(txtAddress.getText())){
            txtAddress.setStyle("-fx-border-color: green");
            isMatchAddress=true;
        }else {
            txtAddress.setStyle("-fx-border-color: red");
            isMatchAddress=false;
        }
    }
    public void btnAdd(ActionEvent actionEvent) {
        if (!isMatchCustomerID){
        }else if(!isMatchName){
        } else if (!isMatchTelNo) {
        } else if (!isMatchAddress){
        } else if (!isMatchEmail) {
        } else if (!isMatchNic) {
        } else {
            String CustomerId = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String telNo = txtTelNo.getText();
            String email = txtEmail.getText();
            String Nic = txtNic.getText();

            Customer customer = new Customer(CustomerId, name, address, telNo, email, Nic);
            boolean isAdded = false;
            try {
                isAdded = CustomerModel.Add(customer);
                refreshTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Customer Successfully Added..!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful..!");
            }
        }
    }

    public void btnUpdate(ActionEvent actionEvent) {
        if (!isMatchCustomerID){
        }else if(!isMatchName){
        } else if (!isMatchTelNo) {
        } else if (!isMatchAddress){
        } else if (!isMatchEmail) {
        } else if (!isMatchNic) {
        } else {
            String CustomerId = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String telNo = txtTelNo.getText();
            String email = txtEmail.getText();
            String Nic = txtNic.getText();

            Customer customer = new Customer(CustomerId, name, address, telNo, email, Nic);
            boolean isUpdated = false;
            try {
                isUpdated = CustomerModel.Update(customer);
                refreshTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Customer Successfully Updated..!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful..!");
            }
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        String CustomerId = txtId.getText();
        try {
            boolean isDeleted = CustomerModel.Delete(CustomerId);
            refreshTableData();
            if (isDeleted){
                JOptionPane.showMessageDialog(null,"Successfully Deleted..!");
            }else{
                JOptionPane.showMessageDialog(null,"Unsuccessful..!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnSearch(ActionEvent actionEvent) {
        String Search = txtIdSearch.getText();
        try {
            Customer customer= CustomerModel.SearchId(Search);
            if (customer==null){
                customer= CustomerModel.SearchName(Search);
                if (customer == null) {
                    customer= CustomerModel.SearchAddres(Search);
                    if (customer == null) {
                        customer= CustomerModel.SearchTelNum(Search);
                        if (customer==null){
                            customer= CustomerModel.SearchEmail(Search);
                            if (customer==null){
                                customer= CustomerModel.SearchNic(Search);
                            }
                        }
                    }
                }
            }
            if (customer!=null){
                txtId.setText(customer.getCustomerId());
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtTelNo.setText(customer.getTelNumber());
                txtEmail.setText(customer.getEmail());
                txtNic.setText(customer.getNic());
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Not Found..!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void tblCustomerOnMouseClick(MouseEvent mouseEvent) {
        Customer customer = tblCustomer.getSelectionModel().getSelectedItem();
        if (customer!=null) {
            txtId.setText(customer.getCustomerId());
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtEmail.setText(customer.getEmail());
            txtNic.setText(customer.getName());
            txtTelNo.setText(customer.getTelNumber());
            btnAddDisable.setDisable(true);
        }
    }
}
