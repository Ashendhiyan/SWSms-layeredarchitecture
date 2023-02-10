package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.Dao.CrudDAO;
import lk.ijse.SpiceWholesaleShop.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException;

}
