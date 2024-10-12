
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import Interface.Product;

public class ShoppingCart {
  private ArrayList<Product> Cart;

  // Init shopping cart
  public ShoppingCart() {
    this.Cart = new ArrayList<Product>();
  }

  public void addProduct(Product product) {
    this.Cart.add(product);
  }

  public String getTotalPrice() {
    double sum = 0;
    NumberFormat formatter = NumberFormat.getInstance(Locale.US);
    for (Product i : this.Cart) {
      sum += i.getPrice();
    }
    return formatter.format(sum);
  }

  public void removeProduct(String ProductKey) {
    // cách 1
    int find_index = 0;
    for (Product i : this.Cart) {
      if (ProductKey.equalsIgnoreCase(i.getProductCode())) {
        this.Cart.remove(find_index);
        break;
      }
      find_index++;
    }

    // cách 2 : lambda expression
    // this.Cart.removeIf(find -> ProductKey.equals(find.getProductCode()));
  }
}
