package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.CrudDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.CustomerDAO;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.entity.Employees;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT customer_id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public boolean save(Customer entity) throws SQLException {
        return CrudUtil.execute("Insert Into Customer Values(?,?,?,?,?,?)",
                entity.getCustomerId(),
                entity.getName(),
                entity.getAddress(),
                entity.getTelNumber(),
                entity.getEmail(),
                entity.getNic()
        );
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        return CrudUtil.execute("Update Customer Set name=?,address=?,telNo=?,email=?,nic=? Where customer_id=?",
                entity.getName(),
                entity.getAddress(),
                entity.getTelNumber(),
                entity.getEmail(),
                entity.getNic(),
                entity.getCustomerId()
        );
    }

    @Override
    public List<Customer> search(String text) throws SQLException {
        text = "%"+text+"%";
        ResultSet result=CrudUtil.execute("SELECT * FROM Customer WHERE customer_id LIKE ? OR name LIKE ? OR  address LIKE ? OR telNo LIKE ? OR email LIKE ? OR nic LIKE ?",
                text,text,text,text,text,text);
        List<Customer>CustomerArrayList=new ArrayList<>();
        while (result.next()){
            CustomerArrayList.add(new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            ));
        }
        return CustomerArrayList;
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException {
        return CrudUtil.execute("Delete From Customer Where customer_id = ?",pk);
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        ResultSet result=CrudUtil.execute("SELECT *FROM customer");
        ArrayList<Customer>CustomerArrayList=new ArrayList<>();
        while (result.next()){
            CustomerArrayList.add(new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            ));
        }
        return CustomerArrayList;
    }

    @Override
    public Optional<Customer> findByPk(String pk) throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM Customer WHERE customer_id=?",pk);
        if (result.next()){
            return Optional.of(new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            ));
        }
        return Optional.empty();
    }
}
