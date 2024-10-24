package quanlinguoi.Nguoi;

import java.util.List;

public abstract class Nguoi {
    protected String id;
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String username;
    protected String password;

    public Nguoi(String id, String name, String address, String phoneNumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    // Getter cho ID
    public String getId() {
        return id;
    }

    // Getter cho tên
    public String getName() {
        return name;
    }

    // Getter cho địa chỉ
    public String getAddress() {
        return address;
    }

    // Getter cho số điện thoại
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter cho tên đăng nhập
    public String getUsername() {
        return username;
    }

    // Getter cho mật khẩu
    public String getPassword() {
        return password;
    }

     // Setter methods
     public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Phương thức trừu tượng cho đăng ký
    public abstract void register();

    // Phương thức trừu tượng cho đăng nhập
    public abstract boolean login(String username, String password);

    // Phương thức trừu tượng để xem danh sách người dùng đang đăng nhập
    public abstract void viewLoggedInUsers(List<User> userList, List<Manager> managerList);
}
