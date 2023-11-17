/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        dsNV.load();
        dsKH.load();
        showIndex();
        int choose = 0;
        do {
            showDangNhap();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    dangNhapKhachHang();
                    break;
                case 2:
                    dangNhapThanhVien();
                    break;
                case 3:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 3);
    }
    
    static QuanLiKho quanlikho;
    static DsNhanVien dsNV = new DsNhanVien();
    static DsKhachHang dsKH = new DsKhachHang();
    static GiamDoc giamdoc = new GiamDoc();
    static Scanner sc = new Scanner(System.in);

    public static void showIndex() {
        System.out.println(" *************************************************");
        System.out.println("**                                                **");
        System.out.println("**           QUAN LI CUA HANG DIEN THOAI          **");
        System.out.println("**                                                **");
        System.out.println(" ************************************************** ");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
    }

    public static void showDangNhap() {
        System.out.println("******************** DANG NHAP ********************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** Ban Muon Dang Nhap Voi Tu Cach :              **");
        System.out.println("** 1. Khach Hang                                 **");
        System.out.println("** 2. Thanh Vien Cua hang                        **");
        System.out.println("** 3. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");

    }

    public static void dangNhapThanhVien() throws IOException {
        int choose = 0;
        do {
            showThanhVien();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    dangNhapGiamDoc();
                    break;
                case 2:
                    dangNhapNhanSu();
                    break;
                case 3:
                    dangNhapQuanLiKho();
                    break;
                case 4:
                    dangNhapTaiChinhKH();
                    break;
                case 5:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 5);
    }

    public static void showThanhVien() {
        System.out.println("***************** THANH VIEN CUA HANG *************");
        System.out.println("---------------------------------------------------");
        System.out.println("** Ban Muon Dang Nhap Voi Tu Cach :              **");
        System.out.println("** 1. Giam Doc                                   **");
        System.out.println("** 2. Quan Li Nhan Su                            **");
        System.out.println("** 3. Quan Li Kho                                **");
        System.out.println("** 4. Quan Li Tai Chinh va Khach Hang            **");
        System.out.println("** 5. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }
    
    public static void dangNhapGiamDoc() throws IOException {
        int choose = 0;

        do {
            showQuyenGiamDoc();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    dangNhapNhanSu();
                    break;
                case 2:
                    dangNhapQuanLiKho();
                    break;
                case 3:
                    dangNhapTaiChinhKH();
                    break;
                case 4:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 4);
    }
    
    public static void showQuyenGiamDoc() {
        System.out.println("********************* GIAM DOC ********************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** Truy Cap Voi Quyen :                          **");
        System.out.println("** 1. Quan Li Nhan Su                            **");
        System.out.println("** 2. Quan Li Kho                                **");
        System.out.println("** 3. Quan Li Tai Chinh Va Khach Hang            **");
        System.out.println("** 4. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }

    public static void dangNhapNhanSu() throws IOException {
        dsNV.load();
        int choose = 0;
        do {
            showQuyenQuanLiNhanSu();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    dsNV.add();
                    dsNV.load();
                    break;
                case 2:
                    dsNV.remove();
                    dsNV.load();
                    break;
                case 3:
                    dsNV.edit();
                    break;
                case 4:
                    dsNV.showInfo();
                    break;
                case 5:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 5);
    }
    
    public static void showQuyenQuanLiNhanSu() {
        System.out.println("********************* NHAN SU *********************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** 1. Them Nhan Vien                             **");
        System.out.println("** 2. Xoa Nhan Vien                              **");
        System.out.println("** 3. Sua Nhan Vien                              **");
        System.out.println("** 4. Xuat Thong Tin Nhan Vien                   **");
        System.out.println("** 5. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }

    public static void dangNhapQuanLiKho() throws IOException {
        quanlikho = new QuanLiKho();
        quanlikho.dssanpham.load();
        int choose = 0;
        do {
            showQuyenQuanLiKho();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    quanlikho.dssanpham.edit();
                    quanlikho.dssanpham.load();
                    break;
                case 2:
                    quanlikho.dssanpham.showDsDienThoai();
                    System.out.println("");
                    break;
                case 3:
                    quanlikho.dssanpham.showDsPhuKien();
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 4);
    }
    
    public static void showQuyenQuanLiKho() {
        System.out.println("******************* QUAN LI KHO *******************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** 1. Thay doi thong tin                         **");
        System.out.println("** 2. Xem Danh Sach Dien Thoai                   **");
        System.out.println("** 3. Xem Danh Sach Phu Kien                     **");
        System.out.println("** 4. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }

    public static void dangNhapKhachHang() throws IOException {
        dsKH.load();
        KhachHang kh = new KhachHang();
        kh.input();
        kh.dssanpham.load();
        int choose = 0;
        do {
            showKhachHang();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    kh.dssanpham.showDsDienThoai();
                    kh.hoadon.inputDienThoai(kh.getMaKH());
                    break;
                case 2:
                    kh.dssanpham.showDsPhuKien();
                    kh.hoadon.inputPhuKien(kh.getMaKH());
                    break;
                case 3:
                    kh.hoadon.edit(kh.getMaKH());
                    break;
                case 4:
                    kh.xuatHoaDon();
                    break;
                case 5:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 5);
        dsKH.add(kh);
        dsKH.writeFile();
    }
    
    public static void showKhachHang() {
        System.out.println("******************** KHACH HANG *******************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** 1. Mua Dien Thoai                             **");
        System.out.println("** 2. Mua Phu Kien                               **");
        System.out.println("** 3. Thay doi San Pham                          **");
        System.out.println("** 4. Xuat Hoa Don                               **");
        System.out.println("** 5. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");

    }

    public static void dangNhapTaiChinhKH() throws IOException {
        dsKH.load();
        int choose = 0;
        do {
            showDsTaiChinhKH();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    dsKH.showInfo();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Tong Thu : " + dsKH.TongChi());
                    System.out.println("");
                    break;
                case 3:
                    dsKH.showInfo();
                    dsKH.remove();
                    dsKH.load();
                    break;
                case 4:
                    System.out.println("Nhap Thong Tin Khach Hang Can Them : ");
                    KhachHang kh = new KhachHang();
                    kh.inputAll();
                    dsKH.add(kh);
                    dsKH.load();
                    break;
                case 5:
                    timKiemKh();
                    break;
                case 6:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 6);
    }

    public static void showDsTaiChinhKH() {
        System.out.println("************* TAI CHINH & KHACH HANG **************");
        System.out.println("----------------------------------------------------");
        System.out.println("** 1. Xem Danh Sach Khach Hang                   **");
        System.out.println("** 2. Tong Thu Nhap Gan Day                      **");
        System.out.println("** 3. Xoa Khach Hang                             **");
        System.out.println("** 4. Them Khach Hang                            **");
        System.out.println("** 5. Tim Kiem Khach Hang                        **");
        System.out.println("** 6. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }
    
    public static void timKiemKh() throws IOException {
        int choose = 0;
        dsKH.load();
        String name = "";
        do {
            showDsTimKiem();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Khach Hang Can Tim :");
                    name = sc.nextLine();
                    String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-1s|\n";
                    String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s \n";
                    System.out.format(format2, "", "            DANH SACH KHACH HANG        ", "", "", "    ");
                    System.out.format(format2, "", "            ********************        ", "", "", "    ");
                    System.out.println("");
                    System.out.format(format1, "Ma KH", "Ho Ten", "So DT", "Ngay Mua", "Tong chi");
                    System.out.println("========================================================================================================================");
                    dsKH.findNv(name).showInfo();
                    break;
                case 2:
                    System.out.println("Nhap Ten Can Tim :");
                    String name1 = sc.nextLine();
                    dsKH.findHoten(name1);
                    break;
                case 3:
                    System.out.println("Hen gap lai !!");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai !! Xin vui long nhap lai !!");
            }
        } while (choose != 3);
    }
    
    public static void showDsTimKiem() {
        System.out.println("********************* TIM KIEM ********************");
        System.out.println("**-----------------------------------------------**");
        System.out.println("** 1. Theo Ma Khach Hang                         **");
        System.out.println("** 2. Theo Ho va Ten                             **");
        System.out.println("** 3. Exit                                       **");
        System.out.println("**-----------------------------------------------**");
        System.out.println("***************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }
}