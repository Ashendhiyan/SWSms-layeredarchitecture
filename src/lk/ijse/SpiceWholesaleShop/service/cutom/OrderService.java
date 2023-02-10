package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.entity.Spice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface OrderService {

    public Optional<Spice> SearchSpice(String code) throws SQLException, ClassNotFoundException;
    public ArrayList<String> LoadItem() throws SQLException, ClassNotFoundException;
    public String generateOrderId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException;
    public Optional<Customer> SearchCustomer(String code) throws SQLException, ClassNotFoundException;
}
