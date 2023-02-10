package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.CustomerDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.PurchaseDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.SpiceDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.CustomerDAOImpl;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.PurchaseDAOImpl;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.SpiceDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.service.cutom.PurchaseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class PurchaseFormServiceImpl implements PurchaseService {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    SpiceDAO spiceDAO=new SpiceDAOImpl();
    PurchaseDAO purchaseDAO=new PurchaseDAOImpl();
    @Override
    public ArrayList<String> loadItem() throws SQLException, ClassNotFoundException {
        return spiceDAO.loadItemCodes();
    }
    @Override
    public String generatePurchaseId() throws SQLException, ClassNotFoundException {
        return purchaseDAO.generateNextPurchaseId();
    }
    @Override
    public ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.loadIds();
    }
    @Override
    public Optional<Customer> SearchCustomer(String code) throws SQLException, ClassNotFoundException {
        return customerDAO.findByPk(code);
    }
    @Override
    public Optional<Spice> SearchSpice(String code) throws SQLException, ClassNotFoundException {
        return spiceDAO.findByPk(code);
    }
}
