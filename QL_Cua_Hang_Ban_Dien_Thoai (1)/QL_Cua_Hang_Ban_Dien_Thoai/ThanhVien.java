/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL_Cua_Hang_Ban_Dien_Thoai;

import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class ThanhVien {
    private String hoten;
    private String diachi;
    private String phone;
    private String gioitinh;
    private String ngaysinh;

    public ThanhVien() {
    }

    public ThanhVien(String hoten, String diachi,String ngaysinh, String phone, String gioitinh) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.phone = phone;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
    }

    public String getNgaySinh() {
        return ngaysinh;
    }

    public void setNgaySinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getHoTen() {
        return hoten;
    }

    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }

    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGioiTinh() {
        return gioitinh;
    }

    public void setGioiTinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ten : ");
        hoten = sc.nextLine();
        System.out.println("Nhap Gioi Tinh :");
        gioitinh = sc.nextLine();
        System.out.println("Nhap Dia Chi : ");
        diachi = sc.nextLine();
        System.out.println("Nhap Ngay Sinh : ");
        ngaysinh = sc.nextLine();
        System.out.println("Nhap Phone : ");
        phone = sc.nextLine();
        System.out.println("--------------------------------------------------");
    }

    public void showInfo() {
        String format = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-15s|\n";
        System.out.format(format, "Ho Ten", "Dia Chi", "Ngay Sinh", "Gioi Tinh", "Phone");
        System.out.println("====================================================================================================");
        System.out.format(format,getHoTen(),getDiaChi(),getNgaySinh(),getGioiTinh(),getPhone());
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

}

