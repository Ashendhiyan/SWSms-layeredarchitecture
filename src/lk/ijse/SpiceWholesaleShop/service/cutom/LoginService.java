package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.dto.UserDTO;

import java.sql.SQLException;

public interface LoginService {
    public UserDTO SearchName(String  name) throws SQLException;
}
