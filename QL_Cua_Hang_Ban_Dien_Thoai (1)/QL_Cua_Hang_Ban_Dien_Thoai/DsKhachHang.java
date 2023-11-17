/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;

import static QL_Cua_Hang_Ban_Dien_Thoai.DsNhanVien.sc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class DsKhachHang {
    
    public KhachHang[] dsKH;    
    
    public DsKhachHang(KhachHang[] dsKh) {
        this.dsKH = dsKh;
    }

    public DsKhachHang() {
        dsKH = new KhachHang[1];
    }
    
    public KhachHang[] getDsKhachHang() {
        return dsKH;
    }
    
    public void setDsKhachHang(KhachHang[] dsKh) {
        this.dsKH = dsKh;
    }

    public void showInfo() throws IOException {
        load();
        String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-1s|\n";
        String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s \n";
        System.out.format(format2, "", "            DANH SACH KHACH HANG"       , "", "", "    ");
        System.out.format(format2, "", "            ********************"       , "", "", "    ");
        System.out.println("");
        System.out.format(format1, "Ma KH", "Ho Ten", "So DT", "Ngay Mua", "Tong chi");
        System.out.println("==========================================================================================");
        for (int i = 0; i < dsKH.length; i++) {
            dsKH[i].showInfo();
        }
        System.out.println("");
        System.out.println("");
        //        System.out.println(dsKh.length);
    }

    public void load() throws IOException {
        setDsKhachHang(readFile());
    }

    public void add(KhachHang nv) throws FileNotFoundException, IOException {
        load();
        dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
        dsKH[dsKH.length - 1] = nv;
        writeFile();
    }

    public boolean checkManv(String manv) throws IOException {
        setDsKhachHang(readFile());
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getMaNV().equalsIgnoreCase(manv)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkMaKH(String manv) throws IOException {
        setDsKhachHang(readFile());
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(manv)) {
                return false;
            }
        }
        return true;
    }
    public void remove() throws FileNotFoundException, IOException {
        String maNv;
        int choose = 0;
        do {
            System.out.println("***************** XOA KHACH HANG ****************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma Khach Hang :                          **");
            System.out.println("** 2. Ho va Ten :                              **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Khach Hang Can Xoa : ");
                    maNv = sc.nextLine();
                    remove(maNv);
                    writeFile();
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Nhap Ho Ten Khach Hang Can Xoa : ");
                    maNv = sc.nextLine();
                    findHoten(maNv);
                    System.out.println("Nhap Ma Nhan Vien Can Xoa : ");
                    maNv = sc.nextLine();
                    remove(maNv);
                    writeFile();
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Hen Gap Lai ! ");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }
    public KhachHang[] remove(int index) throws FileNotFoundException, IOException {
        for (int i = index; i < dsKH.length - 1; i++) {
            dsKH[i] = dsKH[i + 1];
        }
        dsKH = Arrays.copyOf(dsKH, dsKH.length - 1);
        writeFile();
        return dsKH;
    }

    public KhachHang[] remove(String manv) throws FileNotFoundException, IOException {
        int i = 0;
        boolean check = false;
        for (; i < dsKH.length; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(manv)) {
                check = true;
                break;
            }
        }
        if (check) {
            return remove(i);
        }
        return null;
    }

    public float TongChi() throws IOException {
        float s = 0;
        
        for (int i = 0; i < dsKH.length; i++) {
            dsKH[i].hoadon.load(dsKH[i].getMaKH());
            s += dsKH[i].hoadon.TongTien(dsKH[i].getMaKH());
        }
        return s;
    }

    public int find(String manv) {
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getMaKH().equals(manv)) {
                return i;
            }
        }
        return -1;
    }

    public KhachHang findNv(String manv) throws IOException {
        KhachHang nv = new KhachHang();
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(manv)) {
                nv = dsKH[i];
            }
            
        }
        
        return nv;
    }

    public void findMaNV(String maNv) throws IOException {
        boolean check = false;
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(maNv)) {
                dsKH[i].showInfo();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }
    
    public void findHoten(String name) throws IOException {
        boolean check = false;
        load();
        String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-1s|\n";
        String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s \n";
        System.out.format(format2, "", "            DANH SACH KHACH HANG"       , "", "", "    ");
        System.out.format(format2, "", "            ********************"       , "", "", "    ");
        System.out.println("");
        System.out.format(format1, "Ma KH", "Ho Ten", "So DT", "NgayMua", "Tong chi");
        System.out.println("==========================================================================================");
        for (int i = 0; i < dsKH.length; i++) {
            if (dsKH[i].getName().equalsIgnoreCase(name) || dsKH[i].getName().indexOf(name, 0) > -1 || name.indexOf(dsKH[i].getName(), 0) > -1) {
                dsKH[i].showInfo();
                check = true;
            }
        }
        System.out.println("");
        System.out.println("");
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }

    public int indexFile(String nameFile) throws FileNotFoundException, IOException {
        int i = 0;
        File f = new File(nameFile);
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                i++;
            }
        }
        return i;
    }
    
    public KhachHang[] readFile() throws IOException {
        KhachHang[] ds = new KhachHang[indexFile("DsKH.txt")];
        int i = 0;
        File f = new File("DsKH.txt");
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                KhachHang kh = new KhachHang(data[0], data[1], data[2], data[3], data[4]);
                
                ds[i] = kh;
                i++;
            }
        } else {
            f.createNewFile();
        }
        return ds;
    }
    
    public void writeFile() throws FileNotFoundException, IOException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DsKH.txt"), true);
        for (KhachHang nv : dsKH) {
            String data = nv.getMaKH() + "," + nv.getName() + "," + nv.getPhone() + "," + nv.getMaNV() + "," + nv.getNgayMua();
            out.println(data);
        }
    }
    
    public void deleteFile(String nameFile) {
        File file = new File(nameFile);
        file.delete();
    }
    
}