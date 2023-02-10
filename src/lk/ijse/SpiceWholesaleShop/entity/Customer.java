package lk.ijse.SpiceWholesaleShop.entity;

public class Customer implements SuperEntity{
    private String customerId;
    private String name;
    private String address;
    private String telNumber;
    private String email;
    private String nic;


    public Customer(String customerId, String name, String address, String telNumber, String email, String nic) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
        this.email = email;
        this.nic = nic;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
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

}

