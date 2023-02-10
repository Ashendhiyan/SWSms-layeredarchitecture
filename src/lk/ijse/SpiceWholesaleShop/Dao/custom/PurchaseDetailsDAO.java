package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.Dao.CrudDAO;
import lk.ijse.SpiceWholesaleShop.to.PurchaseCartDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseDetailsDAO extends CrudDAO<P> {
    public boolean savePurchaseDetails(ArrayList<PurchaseCartDetail> cartDetails) throws SQLException, ClassNotFoundException;
}
