package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.Spice;

import java.sql.SQLException;
import java.util.List;

public interface SpiceService {

    public List<Spice> findSpice() throws SQLException;

    public boolean saveSpice(Spice spice) throws SQLException;

    public boolean updateSpice(Spice spice) throws SQLException;

    public boolean deleteSpice(String code) throws SQLException;

    public List<Spice> searchSpice(String Id) throws SQLException;
}
