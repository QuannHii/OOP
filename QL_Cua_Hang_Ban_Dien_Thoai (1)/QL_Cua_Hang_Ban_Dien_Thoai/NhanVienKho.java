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

public class NhanVienKho extends NhanVien {
   
    private String hinhthuc;
    private String vitri = "Kho";
    
    public NhanVienKho() {
    }

    public String getViTri() {
        return vitri;
    }

    public void setViTri(String vitri) {
        this.vitri = vitri;
    }

    public NhanVienKho(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public NhanVienKho(String hinhthuc, String maNV, float giolam) {
        super(maNV, giolam);
        this.hinhthuc = hinhthuc;
    }

    public NhanVienKho(String hinhthuc, String maNV, float giolam, String hoten, String diachi, String ngaysinh, String phone, String gioitinh) {
        super(maNV, giolam, hoten, diachi, ngaysinh, phone, gioitinh);
        this.hinhthuc = hinhthuc;
    }
    public NhanVienKho(String maNV, float giolam, String hoten, String diachi, String ngaysinh, String phone, String gioitinh) {
        super(maNV, giolam, hoten, diachi, ngaysinh, phone, gioitinh);
    }

    

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban muon lam nhan vien voi :");
        System.out.println("Hinh thuc :");
        System.out.println("1. Part Time");
        System.out.println("2. Full Time");
        System.out.println("you choose : ");
        int choose = 0;
        choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                hinhthuc = "Part Time";
                break;
            case 2:
                hinhthuc = "Full Time";
                break;
            default:
                hinhthuc = "Part Time";
                System.out.println("Ban Da nhap sai vui long nhap lai !");
        }
    }


    public String getHinhThuc() {
        return hinhthuc;
    }

    public void setHinhThuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    @Override
    public void showInfo() {
        String format = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-15s \n";
        System.out.format(format, getMaNV(), getHoTen(), getGioiTinh(), getDiaChi(), getPhone(), getHinhThuc(), getViTri());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

    }

}
