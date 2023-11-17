/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class DienThoai {
    
    private String maDT;
    private String tenDT;
    private float gia;
    private int soluong;
    private String ngaynhaphang;

    public String getMaDienThoai() {
        return maDT;
    }

    public void setMaDienThoai(String madt) {
        this.maDT = madt;
    }

    public String getTenDienThoai() {
        return tenDT;
    }

    public void setTenDienThoai(String tendt) {
        this.tenDT = tendt;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soluong;
    }

    public void setSoLuong(int soluong) {
        this.soluong = soluong;
    }

    

    public DienThoai(String maDT, String tenDT, float gia, int soluong, String ngaynhaphang) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.gia = gia;
        this.soluong = soluong;
        this.ngaynhaphang = ngaynhaphang;
    }

    public String getNgayNhapHang() {
        return ngaynhaphang;
    }

    public void setNgayNhapHang(String ngaynhaphang) {
        this.ngaynhaphang = ngaynhaphang;
    }

    public DienThoai() {
    }
    static Scanner sc = new Scanner(System.in);
     public void input(){
        System.out.println("Nhap Ma DT : ");
        maDT = sc.nextLine();
        System.out.println("Nhap ten DT : ");
        tenDT = sc.nextLine();
        System.out.println("Nhap gia tien : ");
        gia = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap so luong : ");
        soluong = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay nhap hang :");
        ngaynhaphang = sc.nextLine();
        System.out.println("--------------------------------------------------");
    }
    public void showInfo(){
        DecimalFormat df = new DecimalFormat("#.00");
        String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s%4$-20d%5$-20s \n";
        System.out.format(format1,"Ma DT","Ten DT","Gia tien","So Luong","Ngay Nhap Hang");
        System.out.println("===========================================================================================");
        System.out.format(format,getMaDienThoai(),getTenDienThoai(),df.format(getGia()),getSoLuong(),getNgayNhapHang());
        System.out.println("-------------------------------------------------------------------------------------------");

    }
    public float TongTien(){
        return getSoLuong()*getGia();
    }
    
}
