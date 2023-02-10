package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.UserDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.UserDAOImpl;
import lk.ijse.SpiceWholesaleShop.dto.UserDTO;
import lk.ijse.SpiceWholesaleShop.entity.User;
import lk.ijse.SpiceWholesaleShop.service.cutom.LoginService;
import lk.ijse.SpiceWholesaleShop.service.util.Convertor;

import java.sql.SQLException;
import java.util.Optional;

public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;
    private final Convertor convertor=new Convertor();

    public LoginServiceImpl() {
        userDAO=new UserDAOImpl();
    }

    @Override
    public UserDTO SearchName(String  name) throws SQLException {
        Optional<User> optional = userDAO.findByUserName(name);
        if (optional.isPresent()){
            User user= optional.get();
            UserDTO userDTO=convertor.fromUser(user);
            return userDTO;
        }
        return null;
    }
}
