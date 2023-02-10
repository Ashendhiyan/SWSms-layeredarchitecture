package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.SpiceDAO;
import lk.ijse.SpiceWholesaleShop.entity.Employees;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.to.CartDetail;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpiceDAOImpl implements SpiceDAO {
    @Override
    public boolean save(Spice spice) throws SQLException {
        return CrudUtil.execute("Insert Into Spice Values(?,?,?,?,?)",
                spice.getItemCode(),
                spice.getPurchasePrice(),
                spice.getUnitPrice(),
                spice.getQtyOnHand(),
                spice.getDescription()
        );
    }

    @Override
    public boolean update(Spice entity) throws SQLException {
        return CrudUtil.execute("Update Spice Set purchase_price=?,unit_price=?,qty_on_hand=?,description=? Where item_code=?",
                entity.getPurchasePrice(),
                entity.getUnitPrice(),
                entity.getQtyOnHand(),
                entity.getDescription(),
                entity.getItemCode()
        );
    }

    @Override
    public List<Spice> search(String text) throws SQLException {
        text = "%"+text+"%";
        ResultSet result=CrudUtil.execute("SELECT * FROM Spice WHERE item_code LIKE ? OR purchase_price LIKE ? OR unit_price LIKE? OR  qty_on_hand LIKE ? OR description LIKE ?",
                text,text,text,text,text);
        List<Spice>SpiceArrayList=new ArrayList<>();
        while (result.next()){
            SpiceArrayList.add(new Spice(
                    result.getString(1),
                    result.getDouble(2),
                    result.getDouble(3),
                    result.getInt(4),
                    result.getString(5)
            ));
        }
        return SpiceArrayList;
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException {
        return CrudUtil.execute("Delete From Spice Where item_code =?",pk);
    }

    @Override
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT item_code FROM spice";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }
    @Override
    public ArrayList<Spice> findAll() throws SQLException{
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

    @Override
    public Optional<Spice> findByPk(String pk) throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM Spice WHERE item_code=?",pk);
        if (result.next()){
            return Optional.of(new Spice(
                    result.getString(1),
                    result.getDouble(2),
                    result.getDouble(3),
                    result.getInt(4),
                    result.getString(5)
            ));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(cartDetail.getQty(),cartDetail.getItemCode())) {
                return false;
            }
        }
        return true;
    }
    private boolean updateQty(int qty,String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Spice SET qty_On_Hand = qty_On_Hand - ? WHERE item_code = ?";
        return CrudUtil.execute(sql,qty, itemCode);
    }
}
