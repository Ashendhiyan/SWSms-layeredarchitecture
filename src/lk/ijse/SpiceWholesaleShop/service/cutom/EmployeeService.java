package lk.ijse.SpiceWholesaleShop.service.cutom;

import lk.ijse.SpiceWholesaleShop.entity.Employees;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    public List<Employees> findEmployees() throws SQLException;
    public boolean saveEmployees(Employees employees) throws SQLException;
    public boolean updateEmployees(Employees employees) throws SQLException;
    public boolean deleteEmployees(String code) throws SQLException;
    public List<Employees> searchEmployees(String Id) throws SQLException;
}
