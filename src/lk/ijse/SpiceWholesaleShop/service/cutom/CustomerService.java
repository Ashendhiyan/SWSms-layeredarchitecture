package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    public List<Customer> findCustomer() throws SQLException;
    public boolean saveCustomer(Customer customer) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
    public boolean deleteCustomer(String code) throws SQLException;
    public List<Customer> searchCustomer(String Id) throws SQLException;
}
