package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.db.DBConnection;
import lk.ijse.SpiceWholesaleShop.to.Order;
import lk.ijse.SpiceWholesaleShop.to.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {
    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = OrderModel.save(new Order(placeOrder.getOrderId(), placeOrder.getCustomerId(),LocalDate.now().toString(),placeOrder.getDescription()));
            if (isOrderAdded) {
                boolean isUpdated = SpiceModel.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = OrderDetailsModel.saveOrderDetails(placeOrder.getOrderDetails());
                    if (isOrderDetailAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
