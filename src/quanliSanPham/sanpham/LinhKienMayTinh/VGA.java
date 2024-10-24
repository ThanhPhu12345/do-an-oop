package quanliSanPham.sanpham.LinhKienMayTinh;

import quanliSanPham.Product;

public class VGA implements Product {
  private final String GuaranteePeriod = "36 months";
  private String vgaModel;
  private Integer vgaVram;
  private Double vgaCoreClock;
  private Integer vgaTdp;
  private Integer vgaPrice;

  // default constructor
  public VGA() {
    this.vgaModel = null;
    this.vgaVram = null;
    this.vgaCoreClock = null;
    this.vgaTdp = null;
    this.vgaPrice = null;
  }

  // constructor
  public VGA(String vgaModel, int vgaVram, double vgaCoreClock, int vgaTdp, int vgaPrice) {
    this.vgaModel = vgaModel;
    this.vgaVram = vgaVram;
    this.vgaCoreClock = vgaCoreClock;
    this.vgaTdp = vgaTdp;
    this.vgaPrice = vgaPrice;
  }

  @Override
  public Integer getPrice() {
    return this.vgaPrice;
  }

  @Override
  public String getProductModel() {
    return this.vgaModel;
  }

  @Override
  public String getGuaranteePeriod() {
    return this.GuaranteePeriod;
  }

  @Override
  public void displaySpecs() {
    System.out.format("%-25s %-4s %-6s %-6s %-20s \n",
        this.vgaModel, this.vgaVram, this.vgaCoreClock, this.vgaTdp, this.vgaPrice);
  }

  public Integer getVgaVram() {
    return this.vgaVram;
  }

  public Double getCoreClock() {
    return this.vgaCoreClock;
  }

  public Integer getVgaTdp() {
    return this.vgaTdp;
  }

  public Integer getVgaPrice() {
    return this.vgaPrice;
  }
}
