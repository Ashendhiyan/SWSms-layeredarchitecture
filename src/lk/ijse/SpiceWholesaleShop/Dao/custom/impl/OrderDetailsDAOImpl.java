package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.OrderDetailsDAO;
import lk.ijse.SpiceWholesaleShop.to.CartDetail;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO order_details VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrderId(), cartDetail.getItemCode(),cartDetail.getQty() ,cartDetail.getUnitPrice(),cartDetail.getTotal());
    }

}
