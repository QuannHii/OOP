/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class KhachHang {
    private String maKH;
    private String name;
    private String phone;
    public DsSanPham dssanpham = new DsSanPham();
    public HoaDon hoadon ;
    private String maNV;
    private String ngaymua;
    DsKhachHang dsKH = new DsKhachHang();

    public KhachHang(String maKH, String name, String phone, String maNV, String ngaymua) {
        this.maKH = maKH;
        this.name = name;
        this.phone = phone;
        this.maNV = maNV;
        this.ngaymua = ngaymua;
    }

    public String getNgayMua() {
        return ngaymua;
    }

    public void setNgayMua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public KhachHang(String maKH, String name, String phone, HoaDon hoadon, String maNV, String ngaymua) throws IOException {
        this.hoadon = new HoaDon();
        this.maKH = maKH;
        this.name = name;
        this.phone = phone;
        this.hoadon = hoadon;
        this.maNV = maNV;
        this.ngaymua = ngaymua;
    }
    
    DsNhanVien dsNv = new DsNhanVien();
    public KhachHang() throws IOException {
        this.hoadon = new HoaDon();
        hoadon = new HoaDon();
        hoadon.load(maKH);
    }

    public KhachHang(String maKH, String name,String phone, HoaDon hoadon) throws IOException {
        this.hoadon = new HoaDon();
        this.maKH = maKH;
        this.name = name;
        this.phone = phone;
        this.hoadon = hoadon;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DsSanPham getdssp() {
        return dssanpham;
    }

    public KhachHang(String maKH, String name, String phone, HoaDon hoadon, String maNV) throws IOException {
        this.hoadon = new HoaDon();
        this.maKH = maKH;
        this.name = name;
        this.phone = phone;
        this.hoadon = hoadon;
        this.maNV = maNV;
    }

    public void setdssp(DsSanPham dssp) {
        this.dssanpham = dssp;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public DsNhanVien getDsNv() {
        return dsNv;
    }

    public void setDsNv(DsNhanVien dsNv) {
        this.dsNv = dsNv;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        KhachHang.sc = sc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }
    
    public void showInfo() throws IOException{
        dsNv.load();
        hoadon = new HoaDon();
        hoadon.load(getMaKH());
        String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s \n";
        System.out.format(format2,getMaKH(),getName(),getPhone(),getNgayMua(),hoadon.TongTien(getMaKH()));
        System.out.println("------------------------------------------------------------------------------------------");

    }
    static Scanner sc = new Scanner(System.in);
    public boolean checkMakh(String makh) throws IOException{
        dsKH.load();
        for(int i=0;i<dsKH.dsKH.length;i++){
            if(dsKH.dsKH[i].getMaKH().equalsIgnoreCase(maKH)) return false;
        }
        return true;
    }
    public void input() throws FileNotFoundException, IOException{
        dsNv.load();
        hoadon = new HoaDon();
        hoadon.load(maKH);
        dsKH.load();
        do {            
             System.out.println("Nhap Ma Khach Hang");
                maKH = sc.nextLine();
                if(dsKH.checkMaKH(maKH)) break;
                else{
                    System.out.println("");
                    System.out.println("Ma Khach Hang Da Ton Tai !! Xin vui long nhap Lai !");
                    System.out.println("");
                }
        } while (true);
        System.out.println("Nhap Ten Khach Hang");
        name = sc.nextLine();
        System.out.println("Nhap So DT : ");
        phone = sc.nextLine();
        System.out.println("Nhap Ngay Mua: ");
        ngaymua = sc.nextLine();
        do {            
           System.out.println("Nhap MaNv Thanh Toan :");
            maNV = sc.nextLine();
            if(dsNv.find(maNV) > -1) break;
            else{
                System.out.println("Ban da nhap sai MaNv !! Xin vui long nhap lai !");
            }
        } while (true);
        System.out.println("-----------------------------------------------");
    }
    public void inputAll() throws FileNotFoundException, IOException{
        dsNv.load();
        dsKH.load();
        hoadon = new HoaDon();
        hoadon.load(maKH);
        do {            
            System.out.println("Nhap Ma Khach Hang");
            maKH = sc.nextLine();
            if(checkMakh(maKH)) break;
            else{
                System.out.println("Ma Khach Hang Da Ton Tai");
            }
        } while (true);
        System.out.println("Nhap Ten Khach Hang");
        name = sc.nextLine();
        System.out.println("Nhap so DT : ");
        phone = sc.nextLine();
        System.out.println("Nhap Ngay Mua : ");
        ngaymua = sc.nextLine();
        do {            
           System.out.println("Nhap MaNv Thanh Toan :");
            maNV = sc.nextLine();
            if(dsNv.find(maNV) > -1) break;
            else{
                System.out.println("Ban da nhap sai MaNv !! Xin vui long nhap lai !");
            }
        } while (true);
        System.out.println("-----------------------------------------------");
        dssanpham.showDsDienThoai();
        hoadon.inputDienThoai(getMaKH());
        dssanpham.showDsPhuKien();
        hoadon.inputPhuKien(getMaKH());
        System.out.println("");
        System.out.println("Cam on ban da dat hang ! , xin vui long doi trong giay lat ! ");
        System.out.println("");
    }
    public void xuatHoaDon() throws IOException{
        dsNv.load();
        dssanpham.load();
        hoadon = new HoaDon();
        hoadon.load(maKH);
        DecimalFormat df = new DecimalFormat("#.00");
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        String format2 = " %1$-40s%2$-1s \n";
        String format3 = " %1$-40s%2$-20s \n";
        System.out.format(format, "", "HOA DON", "");
        System.out.format(format, "", "*******", "");
        System.out.println("");
        System.out.println("------------------- "+getNgayMua()+" -------------------");
        System.out.format(format2,"Nhan Vien Thanh Toan",dsNv.dsNV[dsNv.find(getMaNV())].getHoTen());
        System.out.println("----------------------------------------------------");
        System.out.format(format2,"Khach Hang",getName());
        System.out.println("----------------------------------------------------");
        System.out.format(format1, "Ten San Pham","So Luong" ,"Gia Tien");
        System.out.println("====================================================");
        hoadon.showInfoHoaDon(getMaKH());
        System.out.println("----------------------------------------------------");
        System.out.format(format3,"Tong",df.format(hoadon.TongTien(getMaKH())));
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("");

    }
    public void edit() throws IOException{
        hoadon = new HoaDon();
        hoadon.load(maKH);
        hoadon.edit(maKH);
    }
}
