package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.UserDAO;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User entity) throws SQLException {
        return CrudUtil.execute("Insert Into User Values(?,?,?,?,?,?,?,?)",
                entity.getUserId(),
                entity.getName(),
                entity.getPassword(),
                entity.getUserRank(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getNic(),
                entity.getTelNumber()
        );
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return CrudUtil.execute("Update User Set name=?,password=?,user_rank=?,email=?,address=?,nic=?,telNo=? Where user_id=?",
                entity.getName(),
                entity.getPassword(),
                entity.getUserRank(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getNic(),
                entity.getTelNumber(),
                entity.getUserId()
        );
    }

    @Override
    public List<User> search(String text) throws SQLException {
        text = "%"+text+"%";
        ResultSet result=CrudUtil.execute("SELECT * FROM User WHERE user_id LIKE ? OR name LIKE ? OR password LIKE? OR  user_rank LIKE ? OR email LIKE ? OR address LIKE ? OR nic LIKE ? OR telNo LIKE?",
                text,text,text,text,text,text,text,text);
        List<User>UserArrayList=new ArrayList<>();
        while (result.next()){
            UserArrayList.add(new User(
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
        return UserArrayList;
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException {
        return CrudUtil.execute("Delete From User Where user_id =?",pk);
    }

    @Override
    public List<User> findAll() throws SQLException {
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

    @Override
    public Optional<User> findByPk(String pk) throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM User WHERE user_id=?",pk);
        if (result.next()){
            return Optional.of(new User(
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
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String name) throws SQLException {
        ResultSet result=CrudUtil.execute("SELECT *FROM User WHERE name=?",name);
        if (result.next()){
            return Optional.of(new User(
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
        return Optional.empty();
    }
}
