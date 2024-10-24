package quanlinguoi.Nguoi;

import java.io.*;
import java.util.List;

public class Manager extends Nguoi {
    private static final String FILE_PATH = "managers.txt";

    public Manager(String id, String name, String address, String phone, String username, String password) {
        super(id, name, address, phone, username, password);
    }
//đăng kí quản lí//đa hình
    @Override
    public void register() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(getId() + "," + getName() + "," + getAddress() + "," + getPhoneNumber() + "," + getUsername() + "," + getPassword());
            writer.newLine();
            System.out.println("Đăng ký Manager thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đăng ký Manager: " + e.getMessage());
        }
    }
//đăng nhập quản lí//đa hình
    @Override
    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[4].equals(username) && details[5].equals(password)) {
                    System.out.println("Manager đăng nhập thành công!");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đăng nhập Manager: " + e.getMessage());
        }
        System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác cho Manager.");
        return false;
    }
//xem người dùng đã đăng kí xem cả quản lí//đa hình
    @Override
    public void viewLoggedInUsers(List<User> userList, List<Manager> managerList) {
        System.out.println("\n--- Danh sách người dùng và quản lý đang đăng nhập ---");
        System.out.println("Người dùng:");
        for (User user : userList) {
            System.out.println("User: " + user.getUsername());
        }
        System.out.println("\nQuản lý:");
        for (Manager manager : managerList) {
            System.out.println("Manager: " + manager.getUsername());
        }
    }
}
