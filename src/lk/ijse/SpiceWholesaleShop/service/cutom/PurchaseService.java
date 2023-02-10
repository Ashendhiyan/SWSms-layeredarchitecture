package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.entity.Spice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface PurchaseService {

    public ArrayList<String> loadItem() throws SQLException, ClassNotFoundException;
    public String generatePurchaseId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException;
    public Optional<Customer> SearchCustomer(String code) throws SQLException, ClassNotFoundException;
    public Optional<Spice> SearchSpice(String code) throws SQLException, ClassNotFoundException;
}
