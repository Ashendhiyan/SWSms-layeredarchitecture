package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.to.CartDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailsDAO {
    public boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException;
}
