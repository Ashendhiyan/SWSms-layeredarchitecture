package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.SpiceDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.SpiceDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.service.cutom.SpiceService;

import java.sql.SQLException;
import java.util.List;

public class SpiceFormServiceImpl implements SpiceService {

    SpiceDAO spiceDAO=new SpiceDAOImpl();

    @Override
    public List<Spice> findSpice() throws SQLException {
        return spiceDAO.findAll();
    }
    @Override
    public boolean saveSpice(Spice spice) throws SQLException {
        return spiceDAO.save(spice);
    }
    @Override
    public boolean updateSpice(Spice spice) throws SQLException {
        return spiceDAO.update(spice);
    }
    @Override
    public boolean deleteSpice(String code) throws SQLException {
        return spiceDAO.deleteByPk(code);
    }
    @Override
    public List<Spice> searchSpice(String Id) throws SQLException {
        return spiceDAO.search(Id);
    }
}
