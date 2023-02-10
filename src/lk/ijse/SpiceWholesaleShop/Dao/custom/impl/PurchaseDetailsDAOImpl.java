package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.PurchaseDetailsDAO;
import lk.ijse.SpiceWholesaleShop.to.PurchaseCartDetail;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseDetailsDAOImpl implements PurchaseDetailsDAO {
    @Override
    public boolean savePurchaseDetails(ArrayList<PurchaseCartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (PurchaseCartDetail cartDetail : cartDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(PurchaseCartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO purchase_detail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getPurchaseId(), cartDetail.getItemCode(),cartDetail.getUnitPrice(),cartDetail.getQty());
    }
}
