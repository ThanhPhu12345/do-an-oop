package quanlinguoi.Nguoi;

import java.io.*;
import java.util.List;

public class User extends Nguoi {
    private static final String FILE_PATH = "users.txt";

    public User(String id, String name, String address, String phone, String username, String password) {
        super(id, name, address, phone, username, password);
    }
//đăng kí người dùng//đa hình
    @Override
    public void register() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(getId() + "," + getName() + "," + getAddress() + "," + getPhoneNumber() + "," + getUsername() + "," + getPassword());
            writer.newLine();
            System.out.println("Đăng ký User thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đăng ký User: " + e.getMessage());
        }
    }
//đăng nhập người dùng//đa hình
    @Override
    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                // Kiểm tra độ dài của mảng details
                if (details.length >= 6) {
                    if (details[4].equals(username) && details[5].equals(password)) {
                        System.out.println("User đăng nhập thành công!");
                        return true;
                    }
                } else {
                    System.out.println("Dữ liệu không hợp lệ trong file người dùng.");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đăng nhập User: " + e.getMessage());
        }
        System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác cho User.");
        return false;
    }
    //chỉ xem người dùng khác đã đăng kí//đa hình
    @Override
    public void viewLoggedInUsers(List<User> userList, List<Manager> managerList) {
        System.out.println("\n--- Danh sách người dùng đang đăng nhập ---");
        for (User user : userList) {
            System.out.println("User: " + user.getUsername());
        }
    }
}
