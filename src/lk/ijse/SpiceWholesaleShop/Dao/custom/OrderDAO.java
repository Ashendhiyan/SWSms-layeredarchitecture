package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.to.Order;

import java.sql.SQLException;

public interface OrderDAO {
    public boolean save(Order order) throws SQLException, ClassNotFoundException;

    public String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
