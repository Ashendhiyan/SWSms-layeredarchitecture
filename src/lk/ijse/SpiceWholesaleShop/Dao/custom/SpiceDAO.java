package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.Dao.CrudDAO;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.to.CartDetail;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SpiceDAO extends CrudDAO<Spice,String> {
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    public boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException;
}
