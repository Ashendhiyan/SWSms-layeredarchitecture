package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    public List<User> findUser() throws SQLException;
    public boolean saveUser(User user) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public boolean deleteUser(String code) throws SQLException;
    public List<User> searchUser(String Id) throws SQLException;
}
