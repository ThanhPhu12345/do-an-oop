package quanliSanPham.sanpham.LinhKienMayTinh;

import quanliSanPham.Product;

public class RAM implements Product {
  private final String GuaranteePeriod = "36 months";
  private String ramModel;
  private Integer ramCapacity;
  private Integer ramSpeed;
  private String ramType;
  private Integer ramPrice;

  // default constructor
  public RAM() {
    this.ramModel = null;
    this.ramCapacity = null;
    this.ramSpeed = null;
    this.ramType = null;
    this.ramPrice = null;
  }

  // constructor
  public RAM(String ramModel, int ramCapacity, int ramSpeed, String ramType, int ramPrice) {
    this.ramModel = ramModel;
    this.ramCapacity = ramCapacity;
    this.ramSpeed = ramSpeed;
    this.ramType = ramType;
    this.ramPrice = ramPrice;
  }

  @Override
  public Integer getPrice() {
    return this.ramPrice;
  }

  @Override
  public String getProductModel() {
    return this.ramModel;
  }

  @Override
  public String getGuaranteePeriod() {
    return this.GuaranteePeriod;
  }

  @Override
  public void displaySpecs() {
    System.out.format("%-20s %-3s %-6s %-6s %-10s \n",
        this.ramModel, this.ramCapacity, this.ramSpeed, this.ramType, this.ramPrice);
  }

  public Integer getRamCapacity() {
    return this.ramCapacity;
  }

  public Integer getRamSpeed() {
    return this.ramSpeed;
  }

  public String getRamType() {
    return this.ramType;
  }
}
