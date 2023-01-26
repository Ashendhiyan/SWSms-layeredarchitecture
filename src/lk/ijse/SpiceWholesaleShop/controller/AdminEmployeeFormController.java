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
import lk.ijse.SpiceWholesaleShop.model.EmployeesModel;
import lk.ijse.SpiceWholesaleShop.to.Customer;
import lk.ijse.SpiceWholesaleShop.to.Employees;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.util.Service;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminEmployeeFormController {
    public AnchorPane Employee;
    public TextField EmployeeId;
    public TextField txtName;
    public TextField txtRank;
    public TextField txtEmail;
    public TextField txtNic;
    public TextField txtTelNo;
    public TextField txtAddress;
    public TextField txtIdSearch;
    public TableView<Employees> tblEmployee;
    public TableColumn<Employees,String> colEmployeeId;
    public TableColumn<Employees,String> colName;
    public TableColumn<Employees,String> colRank;
    public TableColumn<Employees,String> colAddress;
    public TableColumn<Employees,String> colTelNo;
    public TableColumn<Employees,String> colEmail;
    public TableColumn<Employees,String> colNic;
    public Button btnAddDisable;
    boolean isMatchTelNo=false;
    boolean isMatchEmployeeId=false;
    boolean isMatchName=false;
    boolean isMatchAddress=false;
    boolean isMatchEmail=false;
    boolean isMatchNic=false;
    boolean isMatchRank=false;

    public void initialize(){
        loadTableData();
    }

    private void loadTableData() {
        refreshTableData();
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colRank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("telNumber"));
    }

    private void refreshTableData() {
        try {
            ArrayList<Employees> employees=EmployeesModel.getAllEmployee();
            ObservableList<Employees> EmplopyeeObservableList= FXCollections.observableArrayList();
            EmplopyeeObservableList.addAll(employees);
            tblEmployee.setItems(EmplopyeeObservableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,Employee);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
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
    public void EmployeeIdOnAction(KeyEvent keyEvent) {
        if (Service.isValidEmployeeId(EmployeeId.getText())){
            EmployeeId.setStyle("-fx-border-color: green");
            isMatchEmployeeId=true;
        }else {
            EmployeeId.setStyle("-fx-border-color: red");
            isMatchEmployeeId=false;
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
    public void txtRankOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtRank.getText())){
            txtRank.setStyle("-fx-border-color: green");
            isMatchRank=true;
        }else {
            txtRank.setStyle("-fx-border-color: red");
            isMatchRank=false;
        }
    }

    public void btnAdd(ActionEvent actionEvent) {
        if (!isMatchEmployeeId){
        }else if(!isMatchName){
        } else if (!isMatchRank) {
        } else if (!isMatchAddress) {
        } else if (!isMatchTelNo){
        } else if (!isMatchNic) {
        } else if (!isMatchEmail) {
        } else {
            String id = EmployeeId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String nic = txtNic.getText();
            String telNo = txtTelNo.getText();
            String rank = txtRank.getText();
            Employees employees = new Employees(id, rank, name, address, email, nic, telNo);
            try {
                boolean isAdded = EmployeesModel.Add(employees);
                refreshTableData();
                if (isAdded) {
                    JOptionPane.showMessageDialog(null, "Employee Successfully Added..!");
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful..!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void btnUpdate(ActionEvent actionEvent) {
        if (!isMatchEmployeeId){
        }else if(!isMatchName){
        } else if (!isMatchRank) {
        } else if (!isMatchAddress) {
        } else if (!isMatchTelNo){
        } else if (!isMatchNic) {
        } else if (!isMatchEmail) {
        } else {
            String id = EmployeeId.getText();
            String rank = txtRank.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String nic = txtNic.getText();
            String telNo = txtTelNo.getText();
            Employees employees = new Employees(id, rank, name, address, email, nic, telNo);
            try {
                boolean isUpdated = EmployeesModel.Update(employees);
                refreshTableData();
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Employee Successfully Updated..!");
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful..!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        String id = EmployeeId.getText();
        try {
            boolean isDeleted =EmployeesModel.Delete(id);
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

    public void idSearchOnAction(ActionEvent actionEvent) {
        btnSearch(actionEvent);
    }

    public void btnSearch(ActionEvent actionEvent) {
        String Search = txtIdSearch.getText();
        try {
            Employees employees= EmployeesModel.SearchId(Search);
            if (employees==null){
                employees= EmployeesModel.SearchRank(Search);
                if (employees == null) {
                    employees= EmployeesModel.SearchName(Search);
                    if (employees == null) {
                        employees= EmployeesModel.SearchAddress(Search);
                        if (employees==null){
                            employees= EmployeesModel.SearchEmail(Search);
                            if (employees==null){
                                employees= EmployeesModel.SearchNic(Search);
                                if (employees==null){
                                    employees= EmployeesModel.SearchTelNum(Search);
                                }
                            }
                        }
                    }
                }
            }
            if (employees!=null){
                EmployeeId.setText(employees.getEmployeeId());
                txtRank.setText(employees.getRank());
                txtName.setText(employees.getName());
                txtAddress.setText(employees.getAddress());
                txtEmail.setText(employees.getEmail());
                txtNic.setText(employees.getNic());
                txtTelNo.setText(employees.getTelNumber());
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Not Found..!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblEmployeeOnMouseClick(MouseEvent mouseEvent) {
        Employees employee=tblEmployee.getSelectionModel().getSelectedItem();
        if (employee!=null){
            EmployeeId.setText(employee.getEmployeeId());
            txtRank.setText(employee.getRank());
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
            txtEmail.setText(employee.getEmail());
            txtNic.setText(employee.getNic());
            txtTelNo.setText(employee.getTelNumber());
            btnAddDisable.setDisable(true);
        }
    }
}
