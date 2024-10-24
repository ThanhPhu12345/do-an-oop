package quanliSanPham.sanpham.LinhKienMayTinh;

import quanliSanPham.Product;

public class PSU implements Product {
  private final String GuaranteePeriod = "36 months";
  private String psuModel;
  private Integer psuWattage;
  private String psuEfficiencyRating;
  private Integer psuPrice;

  // default constructor
  public PSU() {
    this.psuModel = null;
    this.psuWattage = null;
    this.psuEfficiencyRating = null;
    this.psuPrice = null;
  }

  // constructor
  public PSU(String psuModel, int psuWattage, String psuEfficiencyRating, int psuPrice) {
    this.psuModel = psuModel;
    this.psuWattage = psuWattage;
    this.psuEfficiencyRating = psuEfficiencyRating;
    this.psuPrice = psuPrice;
  }

  @Override
  public Integer getPrice() {
    return this.psuPrice;
  }

  @Override
  public String getProductModel() {
    return this.psuModel;
  }

  @Override
  public String getGuaranteePeriod() {
    return this.GuaranteePeriod;
  }

  @Override
  public void displaySpecs() {
    System.out.format("%-20s %-5s %-15s %-10s \n",
        this.psuModel, this.psuWattage, this.psuEfficiencyRating, this.psuPrice);
  }

  public Integer getPsuWattage() {
    return this.psuWattage;
  }

  public String getPsuEfficiencyRating() {
    return this.psuEfficiencyRating;
  }
}
