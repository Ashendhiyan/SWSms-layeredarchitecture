package lk.ijse.SpiceWholesaleShop.service.cutom.impl;

import lk.ijse.SpiceWholesaleShop.Dao.custom.EmployeeDAO;
import lk.ijse.SpiceWholesaleShop.Dao.custom.impl.EmployeesDAOImpl;
import lk.ijse.SpiceWholesaleShop.entity.Employees;
import lk.ijse.SpiceWholesaleShop.service.cutom.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO=new EmployeesDAOImpl();
    @Override
    public List<Employees> findEmployees() throws SQLException {
        return employeeDAO.findAll();
    }
    @Override
    public boolean saveEmployees(Employees employees) throws SQLException {
        return employeeDAO.save(employees);
    }
    @Override
    public boolean updateEmployees(Employees employees) throws SQLException {
        return employeeDAO.update(employees);
    }
    @Override
    public boolean deleteEmployees(String code) throws SQLException {
        return employeeDAO.deleteByPk(code);
    }
    @Override
    public List<Employees> searchEmployees(String Id) throws SQLException {
        return employeeDAO.search(Id);
    }
}
