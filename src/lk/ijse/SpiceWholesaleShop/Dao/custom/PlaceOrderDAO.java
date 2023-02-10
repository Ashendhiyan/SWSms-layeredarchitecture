package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.to.PlaceOrder;

import java.sql.SQLException;

public interface PlaceOrderDAO {
    public boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException;
}
