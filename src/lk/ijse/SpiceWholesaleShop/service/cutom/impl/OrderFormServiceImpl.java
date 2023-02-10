package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.CustomerDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.OrderDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.SpiceDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.CustomerDAOImpl;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.OrderDAOImpl;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.SpiceDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.service.cutom.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class OrderFormServiceImpl implements OrderService {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    SpiceDAO spiceDAO=new SpiceDAOImpl();
    OrderDAO orderDAO=new OrderDAOImpl();
    @Override
    public Optional<Spice> SearchSpice(String code) throws SQLException, ClassNotFoundException {
        return spiceDAO.findByPk(code);
    }
    @Override
    public ArrayList<String> LoadItem() throws SQLException, ClassNotFoundException {
        return spiceDAO.loadItemCodes();
    }
    @Override
    public String generateOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNextOrderId();
    }
    @Override
    public ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.loadIds();
    }
    @Override
    public Optional<Customer> SearchCustomer(String code) throws SQLException, ClassNotFoundException {
        return customerDAO.findByPk(code);
    }
}
