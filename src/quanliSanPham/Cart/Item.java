package quanliSanPham.Cart;

//import java.util.Objects;

import quanliSanPham.Product;

public abstract class Item {
  protected Product product;
  //protected String productCode;

  // default constructor
  protected Item() {
    this.product = null;
  }

  // constructor
  protected Item(Product product) {
    this.product = product;
  }

  abstract Product getProduct();

  abstract void showItemSpecs();

  abstract String getItemModel();

  abstract Integer getItemPrice();

  abstract String getItemGuaranteePeriod();

  abstract Integer getItemQuantity();

  abstract void addItem(Product product);

  abstract Integer getTotalPrice();

  //abstract boolean equals(Objects obj);
}
