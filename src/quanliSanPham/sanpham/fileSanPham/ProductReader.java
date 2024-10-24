package quanliSanPham.sanpham.fileSanPham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import quanliSanPham.sanpham.LinhKienMayTinh.CPU;
import quanliSanPham.sanpham.LinhKienMayTinh.Mainboard;
import quanliSanPham.sanpham.LinhKienMayTinh.PSU;
import quanliSanPham.sanpham.LinhKienMayTinh.RAM;
import quanliSanPham.sanpham.LinhKienMayTinh.VGA;

public class ProductReader {
  private static final String cpuListFile = "cpu_list.csv";
  private static final String mainListFile = "main_list.csv";
  private static final String ramListFile = "ram_list.csv";
  private static final String psuListFile = "psu_list.csv";
  private static final String vgaListFile = "vga_list.csv";

  public static ArrayList<CPU> getCpuList() {
    ArrayList<CPU> cpu = new ArrayList<CPU>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(cpuListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        cpu.add(new CPU(
            Split[0],
            Integer.parseInt(Split[1]),
            Double.parseDouble(Split[2]),
            Integer.parseInt(Split[3]),
            Integer.parseInt(Split[4])));
      }
      br.close();
    } catch (IOException e) {
      System.out.println("cpu error error");
    }
    return cpu;
  }

  public static ArrayList<Mainboard> getMainList() {
    ArrayList<Mainboard> main = new ArrayList<Mainboard>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(mainListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        main.add(new Mainboard(
            Split[0],
            Split[1],
            Split[2],
            Integer.parseInt(Split[3])));
      }
      br.close();
    } catch (IOException e) {
      System.out.println("main file error");
    }
    return main;
  }

  public static ArrayList<PSU> getPSUList() {
    ArrayList<PSU> psu = new ArrayList<PSU>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(mainListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        psu.add(new PSU(
            Split[0],
            Integer.parseInt(Split[1]),
            Split[2],
            Integer.parseInt(Split[3])));
      }
      br.close();
    } catch (IOException e) {
      System.out.println("psu file error");
    }
    return psu;
  }

  public static ArrayList<RAM> getRAMList() {
    ArrayList<RAM> ram = new ArrayList<RAM>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(mainListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        ram.add(new RAM(
            Split[0],
            Integer.parseInt(Split[1]),
            Integer.parseInt(Split[2]),
            Split[3],
            Integer.parseInt(Split[4])));
      }
      br.close();
    } catch (IOException e) {
      System.out.println("ram file error");
    }
    return ram;
  }

  public static ArrayList<VGA> getVGAList() {
    ArrayList<VGA> vga = new ArrayList<VGA>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(mainListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        vga.add(new VGA(
            Split[0],
            Integer.parseInt(Split[1]),
            Double.parseDouble(Split[2]),
            Integer.parseInt(Split[3]),
            Integer.parseInt(Split[4])));
      }
      br.close();
    } catch (IOException e) {
      System.out.println("vga file error");
    }
    return vga;
  }
}
