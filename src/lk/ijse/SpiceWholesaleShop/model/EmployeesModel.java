package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.Customer;
import lk.ijse.SpiceWholesaleShop.to.Employees;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesModel {
   public static boolean Add(Employees employees) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("Insert Into employees Values(?,?,?,?,?,?,?)",
               employees.getEmployeeId(),
               employees.getRank(),
               employees.getName(),
               employees.getAddress(),
               employees.getEmail(),
               employees.getNic(),
               employees.getTelNumber()
               );
   }
    public static boolean Update(Employees employees) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update employees Set employee_rank=?,name=?,address=?,email=?,nic=?,telNo=? Where employee_id =?",
                employees.getRank(),
                employees.getName(),
                employees.getAddress(),
                employees.getEmail(),
                employees.getNic(),
                employees.getTelNumber(),
                employees.getEmployeeId()
        );
    }
    public static Employees SearchId(String Search) throws SQLException, ClassNotFoundException {
       ResultSet rst = CrudUtil.execute("Select * From employees Where employee_id=?",Search);
       if (rst.next()){
           return new Employees(rst.getString(
                   "employee_id"),
                   rst.getString("employee_rank"),
                   rst.getString("name"),
                   rst.getString("address"),
                   rst.getString("email"),
                   rst.getString("nic"),
                   rst.getString("telNo")
           );
       }
       return null;
    }
    public static Employees SearchRank(String Search) throws SQLException, ClassNotFoundException {
       ResultSet rst = CrudUtil.execute("Select * From employees Where employee_rank=?",Search);
       if (rst.next()){
           return new Employees(rst.getString(
                   "employee_id"),
                   rst.getString("employee_rank"),
                   rst.getString("name"),
                   rst.getString("address"),
                   rst.getString("email"),
                   rst.getString("nic"),
                   rst.getString("telNo")
           );
       }
       return null;
    }
    public static Employees SearchAddress(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From employees Where address=?",Search);
        if (rst.next()){
            return new Employees(rst.getString(
                    "employee_id"),
                    rst.getString("employee_rank"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("nic"),
                    rst.getString("telNo")
            );
        }
        return null;
    }
    public static Employees SearchEmail(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From employees Where email=?",Search);
        if (rst.next()){
            return new Employees(rst.getString(
                    "employee_id"),
                    rst.getString("employee_rank"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("nic"),
                    rst.getString("telNo")
            );
        }
        return null;
    }
    public static Employees SearchNic(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From employees Where nic=?",Search);
        if (rst.next()){
            return new Employees(rst.getString(
                    "employee_id"),
                    rst.getString("employee_rank"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("nic"),
                    rst.getString("telNo")
            );
        }
        return null;
    }
    public static Employees SearchTelNum(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From employees Where telNo=?",Search);
        if (rst.next()){
            return new Employees(rst.getString(
                    "employee_id"),
                    rst.getString("employee_rank"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("nic"),
                    rst.getString("telNo")
            );
        }
        return null;
    }
    public static Employees SearchName(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From employees Where name=?",Search);
        if (rst.next()){
            return new Employees(rst.getString(
                    "employee_id"),
                    rst.getString("employee_rank"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("nic"),
                    rst.getString("telNo")
            );
        }
        return null;
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From employees Where employee_id ='"+id+"'");
    }
    public static ArrayList<Employees> getAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet result=CrudUtil.execute("SELECT *FROM employees");
        ArrayList<Employees>EmployeeArrayList=new ArrayList<>();
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
