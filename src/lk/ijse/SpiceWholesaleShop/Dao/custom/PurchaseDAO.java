package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.to.Purchase;

import java.sql.SQLException;

public interface PurchaseDAO {
    public boolean save(Purchase purchase) throws SQLException, ClassNotFoundException;
    public String generateNextPurchaseId() throws SQLException, ClassNotFoundException;
}
