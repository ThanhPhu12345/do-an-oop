package quanlinguoi;

import quanlinguoi.Nguoi.Manager;
import quanlinguoi.Nguoi.User;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> userList = new ArrayList<>();
    private static List<Manager> managerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String usersFile = "users.txt"; 
    private static final String managersFile = "managers.txt"; 
     

    public static void main(String[] args) {
        loadUserData();
        loadManagerData();

        while (true) {
            System.out.println("---- MENU ----");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    saveUserData(); // Lưu người dùng trước khi thoát
                    saveManagerData(); // Lưu quản lý trước khi thoát
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void register() {
        System.out.println("Bạn muốn đăng ký cho:");
        System.out.println("1. User");
        System.out.println("2. Manager");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        if (choice == 1) {
            User user = new User(id, name, address, phone, username, password);
            user.register();
            userList.add(user);
        } else if (choice == 2) {
            Manager manager = new Manager(id, name, address, phone, username, password);
            manager.register();
            managerList.add(manager);
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void login() {
        System.out.println("Bạn muốn đăng nhập cho:");
        System.out.println("1. User");
        System.out.println("2. Manager");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        if (choice == 1) {
            User user = new User("", "", "", "", username, password);
            if (user.login(username, password)) {
                System.out.println("Bạn đã đăng nhập thành công với tư cách là User.");
                showUserMenu(user);
            }
        } else if (choice == 2) {
            Manager manager = new Manager("", "", "", "", username, password);
            if (manager.login(username, password)) {
                System.out.println("Bạn đã đăng nhập thành công với tư cách là Manager.");
                showManagerMenu(manager);
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void showUserMenu(User user) {
        while (true) {
            System.out.println("\n--- MENU USER ---");
            System.out.println("1. Xem danh sách người dùng đăng nhập");
            System.out.println("2. Đăng xuất");
            System.out.print("Chọn tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            if (choice == 1) {
                user.viewLoggedInUsers(userList, managerList);
            } else if (choice == 2) {
                System.out.println("Đăng xuất thành công.");
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // private static void showManagerMenu(Manager manager) {
    //     while (true) {
    //         System.out.println("\n--- MENU MANAGER ---");
    //         System.out.println("1. Xem danh sách người dùng đăng nhập");
    //         System.out.println("2. Xem danh sách quản lý đang đăng nhập");
    //         System.out.println("3. Đăng xuất");
    //         System.out.print("Chọn tùy chọn: ");
    //         int choice = scanner.nextInt();
    //         scanner.nextLine(); // Clear the newline

    //         if (choice == 1) {
    //             manager.viewLoggedInUsers(userList, managerList);
    //         } else if (choice == 2) {
    //             System.out.println("\n--- Danh sách quản lý đang đăng nhập ---");
    //             for (Manager m : managerList) {
    //                 System.out.println("Manager: " + m.getUsername());
    //             }
    //         } else if (choice == 3) {
    //             System.out.println("Đăng xuất thành công.");
    //             break;
    //         } else {
    //             System.out.println("Lựa chọn không hợp lệ.");
    //         }
    //     }
    // }
    private static void showManagerMenu(Manager manager) { 
        while (true) {
            System.out.println("\n--- MENU MANAGER ---");
            System.out.println("1. Xem danh sách người dùng đăng nhập");
            System.out.println("2. Xem danh sách quản lý đang đăng nhập");
            System.out.println("3. Thêm người dùng");
            System.out.println("4. Sửa người dùng");
            System.out.println("5. Xóa người dùng");
            System.out.println("6. Thêm quản lý");
            System.out.println("7. Sửa quản lý");
            System.out.println("8. Xóa quản lý");
            System.out.println("9. Đăng xuất");
            System.out.print("Chọn tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    manager.viewLoggedInUsers(userList, managerList);
                    break;
                case 2:
                    System.out.println("\n--- Danh sách quản lý đang đăng nhập ---");
                    for (Manager m : managerList) {
                        System.out.println("Manager: " + m.getUsername());
                    }
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    editUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    addManager();
                    break;
                case 7:
                    editManager();
                    break;
                case 8:
                    deleteManager();
                    break;
                case 9:
                    System.out.println("Đăng xuất thành công.");
                    return; // Exit the loop
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // Add a user
    private static void addUser() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        User newUser = new User(id, name, address, phoneNumber, username, password);
        userList.add(newUser);
        saveUserData();
        System.out.println("Người dùng đã được thêm thành công.");
    }

    // Edit a user
    private static void editUser() {
        System.out.print("Nhập ID của người dùng cần sửa: ");
        String id = scanner.nextLine();
        for (User user : userList) {
            if (user.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                user.setName(scanner.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                user.setAddress(scanner.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                user.setPhoneNumber(scanner.nextLine());
                System.out.print("Nhập username mới: ");
                user.setUsername(scanner.nextLine());
                System.out.print("Nhập password mới: ");
                user.setPassword(scanner.nextLine());
                saveUserData();
                System.out.println("Người dùng đã được cập nhật thành công.");
                return;
            }
        }
        System.out.println("Người dùng không tìm thấy.");
    }

    // Delete a user
    private static void deleteUser() {
        System.out.print("Nhập ID của người dùng cần xóa: ");
        String id = scanner.nextLine();
        User userToRemove = null;
        for (User user : userList) {
            if (user.getId().equals(id)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            userList.remove(userToRemove);
            saveUserData();
            System.out.println("Người dùng đã được xóa thành công.");
        } else {
            System.out.println("Người dùng không tìm thấy.");
        }
    }

    // Add a manager
    private static void addManager() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        Manager newManager = new Manager(id, name, address, phoneNumber, username, password);
        managerList.add(newManager);
        saveManagerData();
        System.out.println("Quản lý đã được thêm thành công.");
    }

    // Edit a manager
    private static void editManager() {
        System.out.print("Nhập ID của quản lý cần sửa: ");
        String id = scanner.nextLine();
        for (Manager manager : managerList) {
            if (manager.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                manager.setName(scanner.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                manager.setAddress(scanner.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                manager.setPhoneNumber(scanner.nextLine());
                System.out.print("Nhập username mới: ");
                manager.setUsername(scanner.nextLine());
                System.out.print("Nhập password mới: ");
                manager.setPassword(scanner.nextLine());
                saveManagerData();
                System.out.println("Quản lý đã được cập nhật thành công.");
                return;
            }
        }
        System.out.println("Quản lý không tìm thấy.");
    }

    // Delete a manager
    private static void deleteManager() {
        System.out.print("Nhập ID của quản lý cần xóa: ");
        String id = scanner.nextLine();
        Manager managerToRemove = null;
        for (Manager manager : managerList) {
            if (manager.getId().equals(id)) {
                managerToRemove = manager;
                break;
            }
        }
        if (managerToRemove != null) {
            managerList.remove(managerToRemove);
            saveManagerData();
            System.out.println("Quản lý đã được xóa thành công.");
        } else {
            System.out.println("Quản lý không tìm thấy.");
        }
    }
       //những hàm sau chỉ lưu thông tin người dùng ra file và đọc thông tin người dùng đã đăng kí.không đọc,ghi sản phẩm
    // Phương thức lưu thông tin người dùng vào file
    private static void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            for (User user : userList) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getAddress() + "," +
                             user.getPhoneNumber() + "," + user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu thông tin người dùng: " + e.getMessage());
        }
    }

    // Phương thức lưu thông tin quản lý vào file
    private static void saveManagerData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(managersFile))) {
            for (Manager manager : managerList) {
                writer.write(manager.getId() + "," + manager.getName() + "," + manager.getAddress() + "," +
                             manager.getPhoneNumber() + "," + manager.getUsername() + "," + manager.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu thông tin quản lý: " + e.getMessage());
        }
    }

    // Phương thức tải thông tin người dùng từ file
    private static void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                User user = new User(details[0], details[1], details[2], details[3], details[4], details[5]);
                userList.add(user);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tải thông tin người dùng: " + e.getMessage());
        }
    }

    // Phương thức tải thông tin quản lý từ file
    private static void loadManagerData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(managersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                Manager manager = new Manager(details[0], details[1], details[2], details[3], details[4], details[5]);
                managerList.add(manager);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tải thông tin quản lý: " + e.getMessage());
        }
    }
}
