package lk.ijse.SpiceWholesaleShop.model;

import lk.ijse.SpiceWholesaleShop.to.Customer;
import lk.ijse.SpiceWholesaleShop.to.Spice;
import lk.ijse.SpiceWholesaleShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean Add(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Insert Into Customer Values(?,?,?,?,?,?)",
                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getTelNumber(),
                customer.getEmail(),
                customer.getNic()
        );
    }
    public static Customer SearchId(String Search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where customer_id ='"+Search+"'");
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }
    public static boolean Delete(String CustomerId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From Customer Where customer_id ='"+CustomerId+"'");
    }
    public static boolean Update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Customer Set name=?,address=?,telNo=?,email=?,nic=? Where customer_id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getTelNumber(),
                customer.getEmail(),
                customer.getNic(),
                customer.getCustomerId()
        );
    }
    public static ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
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

    public static Customer SearchName(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where name =?",search);
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }

    public static Customer SearchAddres(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where address =?",search);
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }

    public static Customer SearchTelNum(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where telNo =?",search);
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }

    public static Customer SearchEmail(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where email =?",search);
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }

    public static Customer SearchNic(String search) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("Select * From Customer Where nic =?",search);
        if (rst.next()) {
            return new Customer(rst.getString(
                    "customer_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telNo"),
                    rst.getString("email"),
                    rst.getString("nic"));
        }
        return null;
    }
    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT customer_id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
