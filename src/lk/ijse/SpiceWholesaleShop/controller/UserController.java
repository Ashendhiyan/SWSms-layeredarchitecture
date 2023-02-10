package lk.ijse.SpiceWholesaleShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.service.cutom.UserService;
import lk.ijse.SpiceWholesaleShop.service.cutom.impl.UserServiceImpl;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.util.Service;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController extends Component {
    public AnchorPane User;
    public TextField txtId;
    public TextField txtRank;
    public TextField txtUsername;
    public TextField txtEmail;
    public TextField txtTel;
    public TextField txtNic;
    public TextField txtPassword;
    public TextField txtAddress;
    public TextField txtIdSearch;
    public TableView<User> UserTable;
    public TableColumn<User,String> colUserId;
    public TableColumn<User,String> colUserRank;
    public TableColumn<User,String> colUserName;
    public TableColumn<User,String> colPassword;
    public TableColumn<User,String> colNic;
    public TableColumn<User,String> colTelNo;
    public TableColumn<User,String> colEmail;
    public TableColumn<User,String> colAddress;
    public Button btnAddDisable;

    boolean isMatchTelNo=false;
    boolean isMatchUserId=false;
    boolean isMatchName=false;
    boolean isMatchAddress=false;
    boolean isMatchEmail=false;
    boolean isMatchNic=false;
    boolean isMatchRank=false;
    boolean isMatchPassword=false;

    UserService userService=new UserServiceImpl();

    public void initialize() {
        loadTableData();
    }

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,User);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void txtTelNoOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(txtTel.getText())){
            txtTel.setStyle("-fx-border-color: green");
            isMatchTelNo=true;
        }else {
            txtTel.setStyle("-fx-border-color: red");
            isMatchTelNo=false;
        }
    }
    public void UserIdOnAction(KeyEvent keyEvent) {
        if (Service.isValidUserId(txtId.getText())){
            txtId.setStyle("-fx-border-color: green");
            isMatchUserId=true;
        }else {
            txtId.setStyle("-fx-border-color: red");
            isMatchUserId=false;
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
    public void UserNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtUsername.getText())){
            txtUsername.setStyle("-fx-border-color: green");
            isMatchName=true;
        }else {
            txtUsername.setStyle("-fx-border-color: red");
            isMatchName=false;
        }
    }

    public void PasswordOnAction(KeyEvent keyEvent) {
        if (Service.isValidPassword(txtPassword.getText())){
            txtPassword.setStyle("-fx-border-color: green");
            isMatchPassword=true;
        }else {
            txtPassword.setStyle("-fx-border-color: red");
            isMatchPassword=false;
        }
    }
    public void btnAdd(ActionEvent actionEvent) {
        if (!isMatchUserId) {
        } else if (!isMatchRank) {
        } else if (!isMatchName) {
        } else if (!isMatchPassword) {
        } else if (!isMatchNic) {
        } else if (!isMatchTelNo) {
        } else if (!isMatchEmail) {
        } else if (!isMatchAddress) {
        } else {
            String userId = txtId.getText();
            String userRank = txtRank.getText();
            String name = txtUsername.getText();
            String password = txtPassword.getText();
            String Nic = txtNic.getText();
            String TelNumber = txtTel.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            User user = new User(userId, name, password, userRank, email, address, Nic, TelNumber);
            boolean isAdded = false;
            try {
                isAdded = userService.saveUser(user);
                refreshTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "User Successfully Added..!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful..!");
            }
        }
    }

    public void btnUpdate(ActionEvent actionEvent) {
        if (!isMatchUserId) {
        } else if (!isMatchRank) {
        } else if (!isMatchName) {
        } else if (!isMatchPassword) {
        } else if (!isMatchNic) {
        } else if (!isMatchTelNo) {
        } else if (!isMatchEmail) {
        } else if (!isMatchAddress) {
        } else {
            String userId = txtId.getText();
            String userRank = txtRank.getText();
            String name = txtUsername.getText();
            String password = txtPassword.getText();
            String Nic = txtNic.getText();
            String TelNumber = txtTel.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            User user = new User(userId, name, password, userRank, email, address, Nic, TelNumber);
            boolean isUpdated = false;
            try {
                isUpdated = userService.updateUser(user);
                refreshTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "User Successfully Updated..!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful..!");
            }
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        try {
            boolean isDeleted = userService.deleteUser(txtId.getText());
            refreshTableData();
            if (isDeleted){
                JOptionPane.showMessageDialog(null,"Successfully Deleted..!");
            }else{
                JOptionPane.showMessageDialog(null,"Unsuccessful..!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSearch(ActionEvent actionEvent) {
       txtIdSearch(actionEvent);
    }

    public void txtIdSearch(ActionEvent actionEvent) {
        String Search = txtIdSearch.getText();
        try {
            List<User> users = userService.searchUser(Search);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTableData() {
        refreshTableData();
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colUserRank.setCellValueFactory(new PropertyValueFactory<>("userRank"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("telNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void refreshTableData() {
        try {
            List<User> users = userService.findUser();
            ObservableList<User>userObservableList= FXCollections.observableArrayList();
            userObservableList.addAll(users);
            UserTable.setItems(userObservableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblUserOnMouseClick(MouseEvent mouseEvent) {
        User user=UserTable.getSelectionModel().getSelectedItem();
        if (user!=null){
            txtId.setText(user.getUserId());
            txtUsername.setText(user.getName());
            txtPassword.setText(user.getPassword());
            txtRank.setText(user.getUserRank());
            txtEmail.setText(user.getEmail());
            txtAddress.setText(user.getAddress());
            txtNic.setText(user.getNic());
            txtTel.setText(user.getTelNumber());
            btnAddDisable.setDisable(true);
            UserTable.refresh();

        }
    }

}
