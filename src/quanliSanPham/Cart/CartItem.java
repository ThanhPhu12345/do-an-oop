// CartItem class work as a container in ShoppingCart's ArrayList
package quanliSanPham.Cart;

import java.util.Objects;
import quanliSanPham.Product;

public class CartItem extends Item {
  private int quantityOfProduct;

  // default constructor
  public CartItem() {
    super();
    this.quantityOfProduct = 0;
  }

  // constructor
  public CartItem(Product product) {
    super(product);
    if (product != null) {
      this.quantityOfProduct = 1;
    } else {
      this.quantityOfProduct = 0;
    }
  }

  @Override
  public Product getProduct() {
    return this.product;
  }

  @Override
  public String getItemModel() {
    return this.product.getProductModel();
  }

  @Override
  public Integer getItemPrice() {
    return this.product.getPrice();
  }

  @Override
  public Integer getItemQuantity() {
    return this.quantityOfProduct;
  }

  @Override
  public void addItem(Product product) {
    this.product = product;
  }

  @Override
  public void showItemSpecs() {
    this.product.displaySpecs();
  }

  @Override
  public Integer getTotalPrice() {
    return this.product.getPrice() * this.quantityOfProduct;
  }

  @Override
  public String getItemGuaranteePeriod() {
    return "36 months";
  }

  public void increaseQuantity() {
    this.quantityOfProduct += 1;
  }

  public void changeQuantity(int quantity) {
    if (quantity < 0) {
      System.out.println("số lượng sản phẩm khách muốn thay đổi không hợp lệ");
      return;
    }
    this.quantityOfProduct = quantity;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Product item = (Product) obj;
    return Objects.equals(item.getProductModel(), this.product.getProductModel());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.product.getProductModel());
  }
}
