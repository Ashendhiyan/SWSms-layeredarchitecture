package lk.ijse.SpiceWholesaleShop.to;

public class User {
    private String userId;
    private String name;
    private String password;
    private String userRank;
    private String email;
    private String address;

    public User(String userId, String name, String password, String userRank, String email, String address, String nic, String telNumber) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.userRank = userRank;
        this.email = email;
        this.address = address;
        this.nic = nic;
        this.telNumber = telNumber;
    }

    private String nic;

    public User() {

    }

    private String telNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRank() {
        return userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
