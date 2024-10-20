package quanlyfile;

import Nguoi.User;
import Nguoi.Manager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String USER_FILE = "users.txt";
    private static final String MANAGER_FILE = "managers.txt";
    private static final String PURCHASE_HISTORY_FILE = "purchase_history.txt"; // Lưu lịch sử mua hàng

    // Đọc danh sách người dùng từ file
    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(USER_FILE);
        if (!file.exists()) {
            writeUsers(users); // Tạo file rỗng nếu chưa tồn tại
            return users;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    users.add(new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file người dùng: " + e.getMessage());
        }
        return users;
    }

    // Ghi danh sách người dùng vào file
    public static void writeUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getAddress() + "," +
                        user.getPhoneNumber() + "," + user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file người dùng: " + e.getMessage());
        }
    }

    // Đọc danh sách quản lý từ file
    public static List<Manager> readManagers() {
        List<Manager> managers = new ArrayList<>();
        File file = new File(MANAGER_FILE);
        if (!file.exists()) {
            writeManagers(managers); // Tạo file rỗng nếu chưa tồn tại
            return managers;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    managers.add(new Manager(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file quản lý: " + e.getMessage());
        }
        return managers;
    }

    // Ghi danh sách quản lý vào file
    public static void writeManagers(List<Manager> managers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MANAGER_FILE))) {
            for (Manager manager : managers) {
                writer.write(manager.getId() + "," + manager.getName() + "," + manager.getAddress() + "," +
                        manager.getPhoneNumber() + "," + manager.getUsername() + "," + manager.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file quản lý: " + e.getMessage());
        }
    }
}
// Lưu lịch sử mua hàng vào file
// public static void savePurchaseHistory(String userId, Product product) {
// try (BufferedWriter writer = new BufferedWriter(new
// FileWriter(PURCHASE_HISTORY_FILE, true))) {
// writer.write(userId + "," + product.getId() + "," + product.getProductName()
// + "," +
// product.getPrice() + "," + product.getQuantity());
// writer.newLine();
// } catch (IOException e) {
// System.out.println("Lỗi khi lưu lịch sử mua hàng: " + e.getMessage());
// }
// }

// // Đọc lịch sử mua hàng của người dùng từ file
// public static List<Product> readPurchaseHistory(String userId) {
// List<Product> purchasedProducts = new ArrayList<>();
// File file = new File(PURCHASE_HISTORY_FILE);
// if (!file.exists()) return purchasedProducts; // Nếu chưa có lịch sử thì trả
// về danh sách rỗng
// try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
// String line;
// while ((line = reader.readLine()) != null) {
// String[] parts = line.split(",");
// if (parts.length == 5 && parts[0].equals(userId)) {
// String id = parts[1];
// String name = parts[2];
// double price = Double.parseDouble(parts[3]);
// int quantity = Integer.parseInt(parts[4]);
// purchasedProducts.add(new Product(id, name, price, quantity));
// }
// }
// } catch (IOException e) {
// System.out.println("Lỗi khi đọc lịch sử mua hàng: " + e.getMessage());
// }
// return purchasedProducts;
// }
//

// // Đọc danh sách sản phẩm từ file cố định
// public static List<Product> readProducts() {
// List<Product> products = new ArrayList<>();
// File file = new File(PRODUCT_FILE);
// if (!file.exists()) {
// // Nếu file không tồn tại, tạo mới với dữ liệu mặc định
// writeProducts(products); // Ghi tệp rỗng để tạo
// return products; // Trả về danh sách rỗng
// }
// try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
// String line;
// while ((line = reader.readLine()) != null) {
// String[] parts = line.split(",");
// if (parts.length == 4) {
// products.add(
// new Product(parts[0], parts[1], Double.parseDouble(parts[2]),
// Integer.parseInt(parts[3])));
// }
// }
// } catch (IOException e) {
// System.out.println("Lỗi khi đọc file sản phẩm: " + e.getMessage());
// }
// return products;
// }

// // Ghi danh sách sản phẩm vào file cố định
// public static void writeProducts(List<Product> products) {
// try (BufferedWriter writer = new BufferedWriter(new
// FileWriter(PRODUCT_FILE))) {
// for (Product product : products) {
// writer.write(product.getProductId() + "," + product.getProductName() + "," +
// product.getPrice() + "," + product.getQuantity());
// writer.newLine();
// }
// } catch (IOException e) {
// System.out.println("Lỗi khi ghi file sản phẩm: " + e.getMessage());
// }
// }

// // Lưu sản phẩm vào file
// public static void saveProduct(Product product) {
// List<Product> products = readProducts(); // Đọc danh sách sản phẩm hiện có
// products.add(product); // Thêm sản phẩm mới vào danh sách
// writeProducts(products); // Ghi lại danh sách sản phẩm đã cập nhật vào file
// }

// public static Product getProductById(String productId) {
// List<Product> products = readProducts(); // Đọc danh sách sản phẩm từ file
// for (Product product : products) {
// if (product.getProductId().equals(productId)) {
// return product; // Trả về sản phẩm nếu tìm thấy
// }
// }
// return null; // Nếu không tìm thấy sản phẩm nào
// }

// // Cập nhật sản phẩm trong file
// public static void updateProduct(Product updatedProduct) {
// List<Product> products = readProducts();
// for (int i = 0; i < products.size(); i++) {
// if (products.get(i).getProductId().equals(updatedProduct.getProductId())) {
// products.set(i, updatedProduct); // Cập nhật sản phẩm
// break;
// }
// }
// writeProducts(products); // Ghi lại danh sách sản phẩm đã cập nhật vào file
// }

// // Lưu lịch sử mua hàng vào file
// public static void savePurchaseHistory(List<Product> purchasedProducts) {
// try (BufferedWriter writer = new BufferedWriter(new
// FileWriter(PURCHASE_HISTORY_FILE, true))) { // Ghi bổ sung
// for (Product product : purchasedProducts) {
// writer.write(product.getProductId() + "," + product.getProductName() + "," +
// product.getPrice() + "," + product.getQuantity());
// writer.newLine();
// }
// } catch (IOException e) {
// System.out.println("Lỗi khi ghi lịch sử mua hàng: " + e.getMessage());
// }
// }

// // Đọc lịch sử mua hàng từ file
// public static List<Product> readPurchaseHistory() {
// List<Product> purchasedProducts = new ArrayList<>();
// File file = new File(PURCHASE_HISTORY_FILE);
// if (!file.exists()) {
// return purchasedProducts; // Trả về danh sách rỗng nếu file không tồn tại
// }
// try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
// String line;
// while ((line = reader.readLine()) != null) {
// String[] parts = line.split(",");
// if (parts.length == 4) {
// purchasedProducts.add(
// new Product(parts[0], parts[1], Double.parseDouble(parts[2]),
// Integer.parseInt(parts[3])));
// }
// }
// } catch (IOException e) {
// System.out.println("Lỗi khi đọc lịch sử mua hàng: " + e.getMessage());
// }
// return purchasedProducts;
// }
