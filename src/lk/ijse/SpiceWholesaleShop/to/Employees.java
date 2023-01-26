package lk.ijse.SpiceWholesaleShop.to;

public class Employees {
     private String employeeId;
    private String rank;
    private String name;
    private String address;
    private String email;
    private String nic;
    private String telNumber;

    public Employees(String employeeId, String rank, String name, String address, String email, String nic, String telNumber) {
        this.employeeId = employeeId;
        this.rank = rank;
        this.name = name;
        this.address = address;
        this.email = email;
        this.nic = nic;
        this.telNumber = telNumber;
    }

    public Employees() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
