package quanliSanPham.Cart;

import java.util.ArrayList;

import quanliSanPham.Product;

public class ShoppingCart {
  private ArrayList<CartItem> Cart;
  private int ShoppingCartTotalPrice;
  private boolean valid_item;

  // Init shopping cart
  public ShoppingCart() {
    this.Cart = new ArrayList<CartItem>();
    this.ShoppingCartTotalPrice = 0;
    valid_item = true;
  }

  public void addItem(Product product) {
    // check if item is exist,increase product's quantity
    if (this.Cart.contains(new CartItem(product))) {
      this.Cart.forEach(item -> {
        if (item.getProduct().equals(product)) {
          item.increaseQuantity();
        }
      });
    }

    // or add new item
    this.Cart.add(new CartItem(product));
  }

  public void removeItem(Product product) {
    // check if item isn't exist in shopping cart
    if (!this.Cart.contains(new CartItem(product))) {
      System.out.println("Giỏ hàng chưa có sản phẩm " + product.getProductModel());
      return;
    } else {
      // remove product
      this.Cart.removeIf(item -> item.getProduct().equals(product));
    }
  }

  public void changeItemQuantity(Product product, int newQuantity) {
    // check if item isn't exist in shopping cart
    if (!this.Cart.contains(new CartItem(product))) {
      System.out.println("Giỏ hàng chưa có sản phẩm" + product.getProductModel());
      return;
    } else if (newQuantity < 0) {
      System.out.println("Số lượng không hợp lệ!");
    }

    // change quantity item
    this.Cart.forEach(item -> {
      if (item.getProduct().equals(product)) {
        item.changeQuantity(newQuantity);
      }
    });
  }

  public Integer getTotalPrice() {
    return this.ShoppingCartTotalPrice;
  }

  public void showAllItemCart() {
    for (CartItem item : this.Cart) {
      item.showItemSpecs();
    }
  }

  public void clearCart() {
    this.Cart.clear();
    System.out.println("Xóa toàn bộ sản phẩm trong cart");
  }

  // Null object item check
  public boolean isCartValid() {
    this.Cart.forEach(item -> {
      int index = 0;
      if (item.getItemQuantity() == 0) {
        System.out.println("số lượng sản phẩm " + item.getItemModel() + " không hợp lệ");
        this.valid_item = false;
      }
      if (item.getProduct() == null) {
        System.out.println("có sản phẩm trong shop rỗng(Null Object), index " + index);
        this.valid_item = false;
      }
      index++;
    });
    return this.valid_item;
  }
}
