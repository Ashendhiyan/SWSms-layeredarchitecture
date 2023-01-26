package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.User;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {
    public static boolean Add(User user) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Insert Into User Values(?,?,?,?,?,?,?,?)",
                    user.getUserId(),
                    user.getName(),
                    user.getPassword(),
                    user.getUserRank(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getNic(),
                    user.getTelNumber()
                );
    }
    public static User SearchId(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where user_id =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchPassword(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where password =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchRank(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where user_rank =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchEmail(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where email =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchAddress(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where address =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchName(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where name =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchNic(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where nic =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    } public static User SearchTelNum(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From User Where telNo =?",Search);
        if (rst.next()) {
            return new User(rst.getString(
                    "user_id"),
                    rst.getString("name"),
                    rst.getString("password"),
                    rst.getString("user_rank"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("nic"),
                    rst.getString("telNo"));
        }
        return null;
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From User Where user_id ='"+id+"'");
    }
    public static boolean Update(User user) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update User Set name=?,password=?,user_rank=?,email=?,address=?,nic=?,telNo=? Where user_id=?",
                user.getName(),
                user.getPassword(),
                user.getUserRank(),
                user.getEmail(),
                user.getAddress(),
                user.getNic(),
                user.getTelNumber(),
                user.getUserId()
        );
    }

    public static ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM user");
        ArrayList<User>userArrayList=new ArrayList<>();
        while (result.next()){
            userArrayList.add(new User(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
            ));
        }
        return userArrayList;
    }
}
