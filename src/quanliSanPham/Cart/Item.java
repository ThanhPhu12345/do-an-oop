package quanliSanPham.Cart;

import quanliSanPham.Product;

public abstract class Item {
  protected Product product;

  // default constructor
  protected Item() {
    this.product = null;
  }

  // constructor
  protected Item(Product product) {
    this.product = product;
  }

  abstract void showItemSpecs();

  abstract String getItemModel();

  abstract Integer getItemPrice();

  abstract String getItemGuaranteePeriod();

  abstract Integer getItemQuantity();

  abstract void addItem(Product product);

  abstract Integer getTotalPrice();
}
