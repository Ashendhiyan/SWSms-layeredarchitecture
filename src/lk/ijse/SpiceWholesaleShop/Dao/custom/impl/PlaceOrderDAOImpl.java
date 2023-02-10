package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.OrderDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.OrderDetailsDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.PlaceOrderDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.SpiceDAO;
import lk.ijse.SpiceWholesaleShop.db.DBConnection;
import lk.ijse.SpiceWholesaleShop.to.Order;
import lk.ijse.SpiceWholesaleShop.to.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            OrderDAO orderDAO=new OrderDAOImpl();
            boolean isOrderAdded = orderDAO.save(new Order(placeOrder.getOrderId(), placeOrder.getCustomerId(),LocalDate.now().toString(),placeOrder.getDescription()));
            if (isOrderAdded) {
                SpiceDAO spiceDAO=new SpiceDAOImpl();
                boolean isUpdated = spiceDAO.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    OrderDetailsDAO orderDetailsDAO=new OrderDetailsDAOImpl();
                    boolean isOrderDetailAdded = orderDetailsDAO.saveOrderDetails(placeOrder.getOrderDetails());
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
