package lk.ijse.SpiceWholesaleShop.controller;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.dto.UserDTO;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.service.cutom.LoginService;
import lk.ijse.SpiceWholesaleShop.service.cutom.impl.LoginServiceImpl;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class LoginFormController {

    public AnchorPane ancLogin;
    public TextField txtUserName;
    public TextField txtPassword;
    public ComboBox cmbRank;


    public void initialize() {
        String[] rank = {"Admin", "Cashier"};
        cmbRank.getItems().addAll(rank);
    }

    private Pattern id;
    private Pattern password;

    private void pattern() {
        id = Pattern.compile("^[U-][0-9]{3,}$");
        password = Pattern.compile("^[A-Za-z0-9]{3,}$");
}
    public void LoginOnAction(ActionEvent actionEvent) {


                try {
                    if (txtUserName.getText().isEmpty()|txtPassword.getText().isEmpty()|cmbRank.getSelectionModel().getSelectedItem().toString().isEmpty()){
                        new Alert(Alert.AlertType.WARNING,"Enter All Data").show();
                    }else {
                        String name = txtUserName.getText();
                        String pass = txtPassword.getText();

                        LoginService loginService=new LoginServiceImpl();
                        UserDTO user = loginService.SearchName(name);

                        if (user == null) {
                            new Alert(Alert.AlertType.WARNING, "Wrong Name..Try Again").show();
                        } else {
                            if (pass.equals(user.getPassword())) {
                                String ranks = cmbRank.getSelectionModel().getSelectedItem().toString();

                                    if (ranks.equals("Admin")){
                                        Navigation.navigate(Routes.DASHBOARD, ancLogin);
                                    }else if (ranks.equals("Cashier")){
                                        Navigation.navigate(Routes.CASHIERDASH, ancLogin);
                                    }else {
                                        new Alert(Alert.AlertType.WARNING, "Enter Correct Rank").show();
                                }
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Wrong Password..Try Again").show();
                            }
                        }
                    }
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }

    }
}

