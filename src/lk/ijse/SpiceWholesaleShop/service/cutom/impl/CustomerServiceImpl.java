package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.CustomerDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.CustomerDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.service.cutom.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    @Override
    public List<Customer> findCustomer() throws SQLException {
        return customerDAO.findAll();
    }
    @Override
    public boolean saveCustomer(Customer customer) throws SQLException {
        return customerDAO.save(customer);
    }
    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerDAO.update(customer);
    }
    @Override
    public boolean deleteCustomer(String code) throws SQLException {
        return customerDAO.deleteByPk(code);
    }
    @Override
    public List<Customer> searchCustomer(String Id) throws SQLException {
        return customerDAO.search(Id);
    }
}
