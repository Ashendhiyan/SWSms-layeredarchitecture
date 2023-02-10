package lk.ijse.SpiceWholesaleShop.Dao.custom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.EmployeeDAO;
import lk.ijse.SpiceWholesaleShop.entity.Employees;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(Employees entity) throws SQLException {
        return CrudUtil.execute("Insert Into employees Values(?,?,?,?,?,?,?)",
                entity.getEmployeeId(),
                entity.getRank(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getNic(),
                entity.getTelNumber()
        );
    }

    @Override
    public boolean update(Employees entity) throws SQLException {
        return CrudUtil.execute("Update employees Set employee_rank=?,name=?,address=?,email=?,nic=?,telNo=? Where employee_id =?",
                entity.getRank(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getNic(),
                entity.getTelNumber(),
                entity.getEmployeeId()
        );
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException {
        return CrudUtil.execute("Delete From employees Where employee_id =?",pk);
    }

    @Override
    public List<Employees> findAll() throws SQLException {
        ResultSet result=CrudUtil.execute("SELECT *FROM employees");
        List<Employees>EmployeeArrayList=new ArrayList<>();
        while (result.next()){
            EmployeeArrayList.add(new Employees(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
            ));
        }
        return EmployeeArrayList;
    }

    @Override
    public Optional<Employees> findByPk(String pk) throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM employees WHERE employee_id=?",pk);
        if (result.next()){
            return Optional.of(new Employees(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
            ));
        }
        return Optional.empty();
    }
    @Override
    public List<Employees> search(String text) throws SQLException {
        text = "%"+text+"%";
        ResultSet result=CrudUtil.execute("SELECT * FROM employees WHERE employee_id LIKE ? OR employee_rank LIKE ? OR name LIKE ? OR  address LIKE ? OR email LIKE ? OR nic LIKE ? OR telNo LIKE ?",
                text,text,text,text,text,text,text);
        List<Employees>EmployeeArrayList=new ArrayList<>();
        while (result.next()){
            EmployeeArrayList.add(new Employees(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)
            ));
        }
        return EmployeeArrayList;
    }
}
