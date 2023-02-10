package lk.ijse.SpiceWholesaleShop.service.util;

import lk.ijse.SpiceWholesaleShop.dto.UserDTO;
import lk.ijse.SpiceWholesaleShop.entity.User;

public class Convertor {
    public UserDTO fromUser(User user) {
        return new UserDTO(user.getUserId(), user.getName(), user.getPassword(), user.getUserRank(), user.getEmail(), user.getAddress(), user.getNic(), user.getTelNumber());
    }
}
