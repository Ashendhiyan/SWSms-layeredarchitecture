package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.Order;
import lk.ijse.SpiceWholesaleShop.to.Purchase;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseModel {
    public static boolean save(Purchase purchase) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO purchase VALUES(?, ?, ?, ?,?)";
        return CrudUtil.execute(sql, purchase.getPurchaseId(), purchase.getCustomerId(), purchase.getDate(), purchase.getDescription(),purchase.getTotalPurchasePrice());
    }

    public static String generateNextPurchaseId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT purchase_id FROM purchase ORDER BY purchase_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextPurchaseId(result.getString(1));
        }
        return generateNextPurchaseId(null);
    }

    private static String generateNextPurchaseId(String currentPurchaseId) {
        if (currentPurchaseId != null) {
            String[] split = currentPurchaseId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "P0" + id;
        }
        return "P001";

    }

}
