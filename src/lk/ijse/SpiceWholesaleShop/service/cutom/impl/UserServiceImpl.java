package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.UserDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.UserDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.service.cutom.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAO userDAO=new UserDAOImpl();
    @Override
    public List<User> findUser() throws SQLException {
        return userDAO.findAll();
    }
    @Override
    public boolean saveUser(User user) throws SQLException {
        return userDAO.save(user);
    }
    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.update(user);
    }
    @Override
    public boolean deleteUser(String code) throws SQLException {
        return userDAO.deleteByPk(code);
    }
    @Override
    public List<User> searchUser(String Id) throws SQLException {
        return userDAO.search(Id);
    }
}
