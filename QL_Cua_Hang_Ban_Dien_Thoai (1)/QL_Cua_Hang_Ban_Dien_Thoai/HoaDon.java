/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class HoaDon {
    
    public PhuKien[] dsphukien;
    public DienThoai[] dsdienthoai;
    public DsSanPham dssanpham = new DsSanPham();
    static Scanner sc = new Scanner(System.in);

    public HoaDon() throws IOException {
        dssanpham.load();
    }

    public HoaDon(PhuKien[] dsphukien, DienThoai[] dsdienthoai) {
        this.dsphukien = dsphukien;
        this.dsdienthoai = dsdienthoai;
    }

    public PhuKien[] getDsPhuKien() {
        return dsphukien;
    }

    public void setDsPhuKien(PhuKien[] dsphukien) {
        this.dsphukien = dsphukien;
    }

    public DienThoai[] getDsDienThoai() {
        return dsdienthoai;
    }

    public void setDsDienThoai(DienThoai[] dsdienthoai) {
        this.dsdienthoai = dsdienthoai;
    }

    public void inputPhuKien(String maKH) throws FileNotFoundException, IOException {
        System.out.println("Nhap So Luong Phu Kien Muon Them Vao :");
        int n = Integer.parseInt(sc.nextLine());
        dsphukien = new PhuKien[n];
        String maPK = "";
        for (int i = 0; i < n; i++) {
            dsphukien[i] = new PhuKien();
            System.out.println("Nhap Ma Dien Thoai can mua :");
            maPK = sc.nextLine();
            dsphukien[i] = dssanpham.dsphukien[dssanpham.findMaPhuKien(maPK)];
        }
        writeFilePhuKien(maKH);
    }

    public void load(String maKH) throws IOException {
        setDsDienThoai(readFileDienThoai(maKH));
        setDsPhuKien(readFilePhuKien(maKH));
    }

    public void inputDienThoai(String maKH) throws FileNotFoundException, IOException {
        System.out.println("Nhap So Luong Dien Thoai Muon Them Vao :");
        int n = Integer.parseInt(sc.nextLine());
        dsdienthoai = new DienThoai[n];
        String maDT = "";
        for (int i = 0; i < n; i++) {
            dsdienthoai[i] = new DienThoai();
            System.out.println("Nhap Ma Dien Thoai can them :");
            maDT = sc.nextLine();
            dsdienthoai[i] = dssanpham.dsdienthoai[dssanpham.findDienThoai(maDT)];
        }
        writeFileDienThoai(maKH);
    }
    public void addDienThoai1(String maKH) throws IOException{
        String maDT = "";
        dssanpham.load();
        load(maKH);
        System.out.println("Nhap Ma Dien Thoai can them :");
        maKH = sc.nextLine();
        addDienThoai(dssanpham.dsdienthoai[dssanpham.findDienThoai(maDT)], maKH);
        writeFileDienThoai(maKH);
    }
    public void addPhuKien1(String maKH) throws IOException{
        String maPK = "";
        dssanpham.load();
        load(maKH);
        System.out.println("Nhap Ma Phu Kien can oder :");
        maPK = sc.nextLine();
        addPhuKien(dssanpham.dsphukien[dssanpham.findMaPhuKien(maPK)], maKH);
        writeFilePhuKien(maKH);
    }
    public void showDsPhuKien() {
        System.out.println("");
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Phu Kien", "");
        System.out.format(format, "", "*********", "");
        System.out.println("");

        System.out.format(format1, "Ma PK", "Ten PK", "Gia Tien");
        System.out.println("======================= =============================");
        for (int i = 0; i < dsphukien.length; i++) {
            System.out.format(format, dsphukien[i].getMaPhuKien(), dsphukien[i].getTenPhuKien(), dsphukien[i].getGia());
            System.out.println("----------------------------------------------------");
        }
        System.out.println("");
    }

    public void showDsDienThoai() {
        System.out.println("");
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Dien Thoai", "");
        System.out.format(format, "", "*************", "");
        System.out.println("");
        System.out.format(format1, "Ma DT", "Ten DT", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsdienthoai.length; i++) {
            System.out.format(format, dsdienthoai[i].getMaDienThoai(), dsdienthoai[i].getTenDienThoai(), dsdienthoai[i].getGia());
            System.out.println("----------------------------------------------------");
        }
        System.out.println("");
    }

    public void addPhuKien(PhuKien pk, String maKH) throws FileNotFoundException {
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length + 1);
        dsphukien[dsphukien.length - 1] = pk;
        writeFilePhuKien(maKH);
    }

    public void addPhuKien(String maKH) throws FileNotFoundException, IOException {
        dssanpham.load();
        load(maKH);
        dssanpham.showDsPhuKien();
        inputPhuKien(maKH);
    }

    public void addPhuKien(PhuKien pk, int index, String maKH) throws FileNotFoundException {
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length + 1);
        if (index <= dsphukien.length) {
            for (int i = dsphukien.length - 1; i > index; i--) {
                dsphukien[i] = dsphukien[i - 1];
            }
            dsphukien[index] = pk;
            writeFilePhuKien(maKH);
        } else {
            System.out.println("khong them dc");
        }
    }

    public PhuKien[] removePhuKien(int index, String maKH) throws FileNotFoundException {
        for (int i = index; i < dsphukien.length - 1; i++) {
            dsphukien[i] = dsphukien[i + 1];
        }
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length - 1);
        writeFilePhuKien(maKH);
        return dsphukien;
    }

    public PhuKien[] removePhuKien(PhuKien pk, String maKH) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(pk.getMaPhuKien())) {
                check = true;
                break;
            }
        }
        if (check) {
            return removePhuKien(i, maKH);
        }
        return null;
    }

    public PhuKien[] removePhuKien(String maPK, String maKH) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) {
                check = true;
                break;
            }
        }
        if (check) {
            return removePhuKien(i, maKH);
        }
        return null;
    }

    public void addDienThoai(DienThoai dt, String maKH) throws FileNotFoundException {
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length + 1);
        dsdienthoai[dsdienthoai.length - 1] = dt;
        writeFileDienThoai(maKH);
    }

    public void addDienThoai(String maKH) throws FileNotFoundException, IOException {
        dssanpham.load();
        load(maKH);
        dssanpham.showDsDienThoai();
        inputDienThoai(maKH);
    }

    public void addDienThoai(DienThoai dt, int index, String maKH) throws FileNotFoundException {
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length + 1);
        if (index <= dsdienthoai.length) {
            for (int i = dsdienthoai.length - 1; i > index; i--) {
                dsdienthoai[i] = dsdienthoai[i - 1];
            }
            dsdienthoai[index] = dt;
            writeFileDienThoai(maKH);
        } else {
            System.out.println("khong them dc");
        }
    }

    public void removeDienThoai(String maKH) throws FileNotFoundException {
        String maDT;
        int choose = 0;
        do {
            System.out.println("************ UpDate Dien Thoai *************");
            System.out.println("**----------------------------------------**");
            System.out.println("** Ban Tim theo                           **");
            System.out.println("** 1. Ma DT :                             **");
            System.out.println("** 2. Ten DT :                            **");
            System.out.println("** 3. Exit !!                             **");
            System.out.println("**----------------------------------------**");
            System.out.println("********************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma DT Can Xoa : ");
                    maDT = sc.nextLine();
                    removeDienThoai(maDT, maKH);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Nhap Ten DT Can Xoa : ");
                    maDT = sc.nextLine();
                    findTenDienThoai(maDT);
                    System.out.println("Nhap Ma DT Can Xoa : ");
                    maDT = sc.nextLine();
                    removeDienThoai(maDT, maKH);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }

    public void removePhuKien(String maKH) throws FileNotFoundException {
        String maPK;
        int choose = 0;
        do {
            System.out.println("**************** UpDate Phu Kien  ***************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma Phu Kien :                            **");
            System.out.println("** 2. Ten Phu Kien :                           **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Phu Kien Can Xoa : ");
                    maPK = sc.nextLine();
                    removePhuKien(maPK, maKH);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Nhap Ten Phu Kien Can Xoa : ");
                    maPK = sc.nextLine();
                    findTenPhuKien(maPK);
                    System.out.println("Nhap Ma Phu Kien Can Xoa : ");
                    maPK = sc.nextLine();
                    removePhuKien(maPK, maKH);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }

    public void suaDienThoai(String maKH) throws FileNotFoundException {
        String maDT;
        int choose = 0;
        do {
            System.out.println("************** UpDate Dien Thoai ***********");
            System.out.println("**----------------------------------------**");
            System.out.println("** Ban Tim th                             **");
            System.out.println("** 1. Ma Dien Thoai :                     **");
            System.out.println("** 2. Ten Dien Thoai :                    **");
            System.out.println("** 3. Exit !!                             **");
            System.out.println("**----------------------------------------**");
            System.out.println("********************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Dien Thoai Can Sua : ");
                    maDT = sc.nextLine();
                    dsdienthoai[findDienThoai(maDT)].input();
                    writeFileDienThoai(maKH);
                    break;
                case 2:
                    System.out.println("Nhap Ten Dien Thoai Can Sua : ");
                    maDT = sc.nextLine();
                    findTenDienThoai(maDT);
                    System.out.println("Nhap Ma Dien Thoai Can Sua : ");
                    maDT = sc.nextLine();
                    dsdienthoai[findDienThoai(maDT)].input();
                    writeFileDienThoai(maKH);
                    break;
                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }

    public void suaPhuKien(String maKH) throws FileNotFoundException {
        String maPK;
        int choose = 0;
        do {
            System.out.println("**************** UpDate Phu Kien ****************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma Phu Kien :                            **");
            System.out.println("** 2. Ten Phu Kien :                           **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Phu Kien Can Sua : ");
                    maPK = sc.nextLine();
                    dsphukien[findMaPhuKien(maPK)].input();
                    writeFilePhuKien(maPK);
                    break;
                case 2:
                    System.out.println("Nhap Ten Phu Kien Can Xoa : ");
                    maPK = sc.nextLine();
                    findTenPhuKien(maPK);
                    System.out.println("Nhap Ma Phu Kien Can Xoa : ");
                    maPK = sc.nextLine();
                    dsphukien[findMaPhuKien(maPK)].input();
                    writeFilePhuKien(maKH);
                    break;
                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }

    public DienThoai[] removeDienThoai(int index, String maKH) throws FileNotFoundException {
        for (int i = index; i < dsdienthoai.length - 1; i++) {
            dsdienthoai[i] = dsdienthoai[i + 1];
        }
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length - 1);
        writeFileDienThoai(maKH);
        return dsdienthoai;
    }

    public DienThoai[] removeDienThoai(DienThoai dt, String maKH) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(dt.getMaDienThoai())) {
                check = true;
                break;
            }
        }
        if (check) {
            return removeDienThoai(i, maKH);
        }
        return null;
    }

    public DienThoai[] removeDienThoai(String maDT, String maKH) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(maDT)) {
                check = true;
                break;
            }
        }
        if (check) {
            return removeDienThoai(i, maKH);
        }
        return null;
    }

    public int findMaPhuKien(String maPK) {
        for (int i = 0; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) {
                return i;
            }
        }
        return -1;
    }

    public int findDienThoai(String dt) {
        for (int i = 0; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equals(dt)) {
                return i;
            }
        }
        return -1;
    }

    public void findTenDienThoai(String tenDT) {
        boolean check = false;
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Dien Thoai", "");
        System.out.format(format, "", "********", "");
        System.out.println("");
        System.out.format(format1, "Ma Dien Thoai", "Ten Dien Thoai", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getTenDienThoai().equalsIgnoreCase(tenDT) || dsdienthoai[i].getTenDienThoai().indexOf(tenDT, 0) > -1 || tenDT.indexOf(dsdienthoai[i].getTenDienThoai(), 0) > -1) {
                System.out.format(format, dsdienthoai[i].getMaDienThoai(), dsdienthoai[i].getTenDienThoai(), dsdienthoai[i].getGia());
                System.out.println("----------------------------------------------------");
                check = true;
            }
        }
        System.out.println("");
        System.out.println("");
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }

    public void findTenPhuKien(String tenPK) {
        boolean check = false;
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Phu Kien", "");
        System.out.format(format, "", "*********", "");
        System.out.println("");
        System.out.format(format1, "Ma Phu Kien", "Ten Phu Kien", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsphukien.length; i++) {
            if (dsphukien[i].getTenPhuKien().equalsIgnoreCase(tenPK) || dsphukien[i].getTenPhuKien().indexOf(tenPK, 0) > -1 || tenPK.indexOf(dsphukien[i].getTenPhuKien(), 0) > -1) {
                System.out.format(format, dsphukien[i].getMaPhuKien(), dsphukien[i].getTenPhuKien(), dsphukien[i].getGia());
                System.out.println("----------------------------------------------------");
                check = true;
            }
        }
        System.out.println("");
        System.out.println("");
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }

    public void editDienThoai(String maKH) throws FileNotFoundException, IOException {
        String msnv1;
        load(maKH);
        int choose = 0;
        do {
            System.out.println("************************ UpDate DT ***********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Them Dien Thoai :                                      **");
            System.out.println("** 2. Xoa Dien Thoai :                                       **");
            System.out.println("** 3. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    dssanpham.load();
                    dssanpham.showDsDienThoai();
                    addDienThoai(maKH);
                    load(maKH);
                    showDsDienThoai();
                    writeFileDienThoai(maKH);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    showDsDienThoai();
                    removeDienThoai(maKH);
                    load(maKH);
                    showDsDienThoai();
                    writeFileDienThoai(maKH);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 3);
    }

    public void editPhuKien(String maKH) throws IOException {
        String msnv1;
        load(maKH);
        int choose = 0;
        do {
            System.out.println("************************ UpDate PK **********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Them Phu Kien :                                   **");
            System.out.println("** 2. Xoa Phu Kien :                                    **");
            System.out.println("** 3. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    dssanpham.load();
                    dssanpham.showDsPhuKien();
                    addPhuKien1(maKH);
                    load(maKH);
                    showDsPhuKien();
                    writeFilePhuKien(maKH);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    showDsPhuKien();
                    removePhuKien(maKH);
                    load(maKH);
                    showDsPhuKien();
                    writeFilePhuKien(maKH);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 3);
    }

    public void edit(String maKH) throws FileNotFoundException, IOException {
        String msnv1;
        load(maKH);
        int choose = 0;
        do {
            System.out.println("************************ UpDate Hoa Don **********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Dien Thoai :                                           **");
            System.out.println("** 2. Phu Kien :                                        **");
            System.out.println("** 3. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    editDienThoai(maKH);

                    break;

                case 2:
                    editPhuKien(maKH);

                    break;

                case 3:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 3);
    }

    public boolean checkDienThoai(String maDT, String maKH) throws IOException {
        setDsDienThoai(readFileDienThoai(maKH));
        for (int i = 0; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(maDT)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPhuKien(String maPK, String maKH) throws IOException {
        setDsPhuKien(readFilePhuKien(maKH));
        for (int i = 0; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) {
                return false;
            }
        }
        return true;
    }

    public float TongTien(String maKH) throws IOException {
        load(maKH);
        float s = 0;
        for (int i = 0; i < dsdienthoai.length; i++) {
            s += dsdienthoai[i].TongTien();
        }
        for (int i = 0; i < dsphukien.length; i++) {
            s += dsphukien[i].TongTien();
        }
        return s;
    }

    public void showInfoHoaDon(String maKH) throws IOException {
        load(maKH);
        dssanpham.load();
        String format1 = " %1$-20s%2$-20s%3$-20s \n";
        for (int i = 0; i < dsdienthoai.length; i++) {
            System.out.format(format1, dsdienthoai[i].getTenDienThoai(), dsdienthoai[i].getSoLuong(), dsdienthoai[i].getGia());
            System.out.println("----------------------------------------------------");
        }
        for (int i = 0; i < dsphukien.length; i++) {
            System.out.format(format1, dsphukien[i].getTenPhuKien(), dsphukien[i].getSoLuong(), dsphukien[i].getGia());
            System.out.println("----------------------------------------------------");
        }

    }

//    doc ghi file
    public void writeFilePhuKien(String maKH) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DsphukienKH" + maKH + ".txt"), true);
        for (PhuKien pk : dsphukien) {
            String data = pk.getMaPhuKien() + "," + pk.getTenPhuKien() + "," + pk.getGia() + "," + pk.getSoLuong() + "," + pk.getNgayNhapHang();
            out.println(data);
        }
    }

    public void writeFileDienThoai(String maKH) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DSdienthoaiKH" + maKH + ".txt"), true);
        for (DienThoai dt : dsdienthoai) {
            String data = dt.getMaDienThoai() + "," + dt.getTenDienThoai() + "," + dt.getGia() + "," + dt.getSoLuong() + "," + dt.getNgayNhapHang();
            out.println(data);
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

    public PhuKien[] readFilePhuKien(String maKH) throws IOException {
        PhuKien[] ds = new PhuKien[indexFile("DsphukienKH" + maKH + ".txt")];
        int i = 0;
        File f = new File("DSphukienKH" + maKH + ".txt");
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                PhuKien pk = new PhuKien(data[0], data[1], Float.parseFloat(data[2]), Integer.parseInt(data[3]), data[4]);
                ds[i] = pk;
                i++;
            }
        } else {
            f.createNewFile();
        }
        return ds;
    }

    public DienThoai[] readFileDienThoai(String maKH) throws IOException {
        DienThoai[] ds = new DienThoai[indexFile("DsdienthoaiKH" + maKH + ".txt")];
        int i = 0;
        File f = new File("DsdienthoaiKH" + maKH + ".txt");
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                DienThoai dt = new DienThoai(data[0], data[1], Float.parseFloat(data[2]), Integer.parseInt(data[3]), data[4]);
                ds[i] = dt;
                i++;
            }
        } else {
            f.createNewFile();
        }
        return ds;
    }

}
