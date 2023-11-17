
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;

import java.util.Scanner;


/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public abstract class NhanVien extends ThanhVien{
    
    private String maNV;
    private float giolam;
    
    public NhanVien() {
    }

    public NhanVien(String maNV, float giolam) {
        this.maNV = maNV;
        this.giolam = giolam;
    }

    public NhanVien(String maNV, float giolam, String hoten, String diachi, String ngaysinh, String phone, String gioitinh) {
        super(hoten, diachi, ngaysinh, phone, gioitinh);
        this.maNV = maNV;
        this.giolam = giolam;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getGioLam() {
        return giolam;
    }

    public void setGioLam(float giolam) {
        this.giolam = giolam;
    }

    @Override
    public void input() {
        super.input(); 
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Ma Nhan Vien : ");
        maNV = sc.nextLine();
        System.out.println("Nhap So Gio Lam :");
        giolam = Float.parseFloat(sc.nextLine());
        System.out.println("--------------------------------------------------");
    }
    
    @Override
    public void showInfo() {
        String format = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-15s \n";
        System.out.format(format,getMaNV(),getHoTen(),getDiaChi(),getNgaySinh(),getGioiTinh(),getPhone());
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

}
