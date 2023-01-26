package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.CartDetail;
import lk.ijse.SpiceWholesaleShop.to.PurchaseCartDetail;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseDetailsModel {
    public static boolean savePurchaseDetails(ArrayList<PurchaseCartDetail> cartDetails) throws SQLException, ClassNotFoundException {
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
