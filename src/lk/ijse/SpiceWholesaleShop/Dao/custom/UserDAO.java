package lk.ijse.SpiceWholesaleShop.Dao.custom;

import lk.ijse.SpiceWholesaleShop.Dao.CrudDAO;
import lk.ijse.SpiceWholesaleShop.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDAO extends CrudDAO<User,String> {

    Optional<User> findByUserName(String name) throws SQLException;
}
