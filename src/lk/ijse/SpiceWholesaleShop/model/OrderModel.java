package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.db.DBConnection;
import lk.ijse.SpiceWholesaleShop.to.Order;
import lk.ijse.SpiceWholesaleShop.to.OrderDetails;
import lk.ijse.SpiceWholesaleShop.to.Spice;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderModel {
    public static boolean save(Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Orders VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, order.getOrderId(), order.getCustomerId(), order.getDate(), order.getDescription());
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT order_id FROM Orders ORDER BY order_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(null);
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "O0" + id;
        }
        return "O001";

    }

}
