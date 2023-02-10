//package lk.ijse.SpiceWholesaleShop.model;
//
//import lk.ijse.SpiceWholesaleShop.db.DBConnection;
//import lk.ijse.SpiceWholesaleShop.to.PlacePurchase;
//import lk.ijse.SpiceWholesaleShop.to.Purchase;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//public class PlacePurchaseModel {
//    public static boolean PlacePurchase(PlacePurchase placePurchase) throws SQLException, ClassNotFoundException {
//        try {
//            DBConnection.getInstance().getConnection().setAutoCommit(false);
//            boolean isOrderAdded = PurchaseModel.save(new Purchase(placePurchase.getPurchaseID(), placePurchase.getCustomerId(),LocalDate.now(),placePurchase.getDescription(),placePurchase.getTotal()));
//            if (isOrderAdded) {
//                boolean isUpdated = SpiceModel.updateQty(placePurchase.getPurchaseDetails());
//                if (isUpdated) {
//                    boolean isOrderDetailAdded = PurchaseDetailsModel.savePurchaseDetails(placePurchase.getPurchaseDetails());
//                    if (isOrderDetailAdded) {
//                        DBConnection.getInstance().getConnection().commit();
//                        return true;
//                    }
//                }
//            }
//            DBConnection.getInstance().getConnection().rollback();
//            return false;
//        } finally {
//            DBConnection.getInstance().getConnection().setAutoCommit(true);
//        }
//    }
//}
