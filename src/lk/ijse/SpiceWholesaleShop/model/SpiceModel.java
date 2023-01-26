package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.CartDetail;
import lk.ijse.SpiceWholesaleShop.to.PurchaseCartDetail;
import lk.ijse.SpiceWholesaleShop.to.Spice;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpiceModel {
    public static boolean Add(Spice spice) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Insert Into Spice Values(?,?,?,?,?)",
                spice.getItemCode(),
                spice.getPurchasePrice(),
                spice.getUnitPrice(),
                spice.getQtyOnHand(),
                spice.getDescription()
        );
    }

    public static Spice SearchId(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From spice Where item_code =?", Search);
        if (rst.next()) {
            return new Spice(rst.getString(
                    "item_code"),
                    rst.getDouble("purchase_price"),
                    rst.getDouble("unit_price"),
                    rst.getInt("qty_on_hand"),
                    rst.getString("description"));
        }
        return null;
    }

    public static Spice SearchPurechasePrice(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From spice Where purchase_price =?", Search);
        if (rst.next()) {
            return new Spice(rst.getString(
                    "item_code"),
                    rst.getDouble("purchase_price"),
                    rst.getDouble("unit_price"),
                    rst.getInt("qty_on_hand"),
                    rst.getString("description"));
        }
        return null;
    }

    public static Spice SearchUnitPrice(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From spice Where unit_price =?", Search);
        if (rst.next()) {
            return new Spice(rst.getString(
                    "item_code"),
                    rst.getDouble("purchase_price"),
                    rst.getDouble("unit_price"),
                    rst.getInt("qty_on_hand"),
                    rst.getString("description"));
        }
        return null;
    }

    public static Spice SearchQtyOnHand(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From spice Where qty_on_hand =?", Search);
        if (rst.next()) {
            return new Spice(rst.getString(
                    "item_code"),
                    rst.getDouble("purchase_price"),
                    rst.getDouble("unit_price"),
                    rst.getInt("qty_on_hand"),
                    rst.getString("description"));
        }
        return null;
    }

    public static Spice SearchDescription(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From spice Where description =?", Search);
        if (rst.next()) {
            return new Spice(rst.getString(
                    "item_code"),
                    rst.getDouble("purchase_price"),
                    rst.getDouble("unit_price"),
                    rst.getInt("qty_on_hand"),
                    rst.getString("description"));
        }
        return null;
    }

    public static boolean Delete(String productId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From Spice Where item_code ='" + productId + "'");
    }

    public static boolean Update(Spice spice) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Spice Set purchase_price=?,unit_price=?,qty_on_hand=?,description=? Where item_code=?",
                spice.getPurchasePrice(),
                spice.getUnitPrice(),
                spice.getQtyOnHand(),
                spice.getDescription(),
                spice.getItemCode()
        );
    }

    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT item_code FROM spice";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    public static ArrayList<Spice> getAllproduct() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT *FROM spice");
        ArrayList<Spice> ProductArrayList = new ArrayList<>();
        while (result.next()) {
            ProductArrayList.add(new Spice(
                    result.getString(1),
                    result.getDouble(2),
                    result.getDouble(3),
                    result.getInt(4),
                    result.getString(5)
            ));
        }
        return ProductArrayList;
    }

    public static boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(cartDetail.getQty(),cartDetail.getItemCode())) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(int qty,String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Spice SET qty_On_Hand = qty_On_Hand - ? WHERE item_code = ?";
        return CrudUtil.execute(sql,qty, itemCode);
    }
}
