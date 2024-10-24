package quanliSanPham.Cart;

import java.util.ArrayList;

import quanliSanPham.Product;

public class ShoppingCart {
  private ArrayList<CartItem> Cart;
  private int ShoppingCartTotalPrice;

  // Init shopping cart
  public ShoppingCart() {
    this.Cart = new ArrayList<CartItem>();
    this.ShoppingCartTotalPrice = 0;
  }

  public void addProduct(Product product) {
    // check if product has exist,increase product's quantity
    for (CartItem item : this.Cart) {
      if (item.getItemModel().equalsIgnoreCase(product.getProductModel())) {
        item.increaseQuantity();
        System.out.println("Số lượng sản phẩm " + product.getProductModel() +
            " : " + item.getItemQuantity());
      }
    }
  }

  public void removeProduct(Product product) {
    //check if product is exist in shopping cart
    if(this.Cart.contains(product)) {

    }
    this.Cart.removeIf(temp -> temp.getItemModel().equalsIgnoreCase(product.getProductModel()));
  }

  public void changeItemQuantity(Product product, int quantity) {
    for (CartItem item : this.Cart) {
      if (item.getItemModel().equalsIgnoreCase(product.getProductModel())) {
        item.changeQuantity(quantity);
        break;
      }
    }
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

  // Null object product check
  public boolean VALID_CART() {
    boolean valid = true;
    int index = 0;
    for (CartItem item : this.Cart) {
      if (item.getItemQuantity() == 0) {
        System.out.println("số lượng sản phẩm " + item.getItemModel() + " không hợp lệ");
        valid = false;
      }
      if (item.isProductNull()) {
        System.out.println("có sản phẩm trong shop rỗng(Null Object), index " + index);
        valid = false;
      }
      index++;
    }
    return valid;
  }
}
