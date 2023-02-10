package lk.ijse.SpiceWholesaleShop.Dao;

import lk.ijse.SpiceWholesaleShop.entity.Employees;
import lk.ijse.SpiceWholesaleShop.entity.SuperEntity;
import lk.ijse.SpiceWholesaleShop.to.Customer;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> {
    public boolean save(T entity) throws SQLException;
    public boolean update(T entity) throws SQLException;

    List<T> search(ID text) throws SQLException;
    public boolean deleteByPk(ID pk) throws SQLException;
    public List<T> findAll() throws SQLException;
    public Optional<T> findByPk(ID pk) throws SQLException, ClassNotFoundException;
}
