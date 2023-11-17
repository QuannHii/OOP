/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import java.io.IOException;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class QuanLiKho {
    
    private NhanVienKho Truongkho ;
    public DsSanPham dssanpham = new DsSanPham();

    public QuanLiKho() throws IOException {
        dssanpham.load();
        Truongkho = new NhanVienKho();
    }
    
    public QuanLiKho(NhanVienKho Truongkho) {
        this.Truongkho = Truongkho;
    }

    public NhanVienKho getTruongKho() {
        return Truongkho;
    }

    public void setTruongKho(NhanVienKho Truongkho) {
        this.Truongkho = Truongkho;
    }

    public DsSanPham getDsSanPham() {
        return dssanpham;
    }

    public void setDsSanPham(DsSanPham dssanpham) {
        this.dssanpham = dssanpham;
    }
    
    public void edit() throws IOException{
        dssanpham.edit();
        dssanpham.load();
    }
    
}
