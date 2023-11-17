/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class DsNhanVien implements Interface {

    public NhanVien[] dsNV;

    public DsNhanVien(NhanVien[] dsnv) {
        this.dsNV = dsnv;
    }

    public DsNhanVien() {
    }

    public NhanVien[] getDsNhanVien() {
        return dsNV;
    }

    public void setDsNhanVien(NhanVien[] dsnv) {
        this.dsNV = dsnv;
    }
    static Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.println("Nhap So Nhan Vien Muon Them Vao :");
        int n = Integer.parseInt(sc.nextLine());
        dsNV = new NhanVien[n];
        int choose = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Vi Tri : ");
            System.out.println("1. Nhan Vien Kho");
            System.out.println("2. Nhan Vien Ban Hang");
            System.out.println("You choose :");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    dsNV[i] = new NhanVienKho();
                    break;
                case 2:
                    dsNV[i] = new NhanVienBanHang();
                    break;
            }
            dsNV[i].input();
        }
    }

    public void showInfo() {
        String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-1s|\n";
        String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-15s%8$-1s \n";
        System.out.format(format2, "", "", "              DANH SACH NHAN VIEN       ", "", "", "", "", "    ");
        System.out.format(format2, "", "", "              *******************       ", "", "", "", "", "    ");
        System.out.println("");
        System.out.format(format1, "Ma NV", "Ho Ten", "Gioi Tinh", "Dia Chi", "Phone", "Hinh Thuc", "Vi Tri");
        System.out.println("========================================================================================================================");

        for (int i = 0; i < dsNV.length; i++) {
            dsNV[i].showInfo();
        }
        System.out.println("");
        System.out.println("");
    }

    public void load() throws IOException {
        setDsNhanVien(readFile());
    }

    public void add(NhanVien nv) throws FileNotFoundException {
        dsNV = Arrays.copyOf(dsNV, dsNV.length + 1);
        dsNV[dsNV.length - 1] = nv;
        writeFile();
    }

    public void add() throws FileNotFoundException, IOException {
        NhanVien nv = null;
        System.out.println("Vi Tri : ");
        System.out.println("1. Nhan Vien Kho");
        System.out.println("2. Nhan Vien Ban Hang");
        System.out.println("You choose :");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                nv = new NhanVienKho();
                break;
            case 2:
                nv = new NhanVienBanHang();
                break;
            default:
                nv = new NhanVienBanHang();

        }
        do {
            System.out.println("Nhap Thong Tin Nhan Vien Moi : ");
            nv.input();
            if (checkMaNV(nv.getMaNV())) {
                add(nv);
                break;
            } else {
                System.out.println("Ma nhan vien da ton tai !! Xin vui long nhap Lai ! ");
                System.out.println("");
            }
        } while (true);
    }

    public boolean checkMaNV(String maNv) throws IOException {
        setDsNhanVien(readFile());
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNv)) {
                return false;
            }
        }
        return true;
    }

    public void add(NhanVien nv, int index) throws FileNotFoundException {
        dsNV = Arrays.copyOf(dsNV, dsNV.length + 1);
        if (index <= dsNV.length) {
            for (int i = dsNV.length - 1; i > index; i--) {
                dsNV[i] = dsNV[i - 1];
            }
            dsNV[index] = nv;
            writeFile();
        } else {
            System.out.println("khong them dc");
        }
    }

    public void remove() throws FileNotFoundException {
        String manV;
        int choose = 0;
        do {
            System.out.println("***************** XOA NHAN VIEN *****************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma Nhan Vien :                           **");
            System.out.println("** 2. Ho va Ten :                              **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Nhan Vien Can Xoa : ");
                    manV = sc.nextLine();
                    remove(manV);
                    writeFile();
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Nhap Ho Ten Nhan Vien Can Xoa : ");
                    manV = sc.nextLine();
                    findHoten(manV);
                    System.out.println("Nhap Ma Nhan Vien Can Xoa : ");
                    manV = sc.nextLine();
                    remove(manV);
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

    public NhanVien[] remove(int index) throws FileNotFoundException {
        for (int i = index; i < dsNV.length - 1; i++) {
            dsNV[i] = dsNV[i + 1];
        }
        dsNV = Arrays.copyOf(dsNV, dsNV.length - 1);
        writeFile();
        return dsNV;
    }

    public NhanVien[] remove(NhanVien nv) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(nv.getMaNV())) {
                check = true;
                break;
            }
        }
        if (check) {
            return remove(i);
        }
        return null;
    }

    public NhanVien[] remove(String maNV) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV)) {
                check = true;
                break;
            }
        }
        if (check) {
            return remove(i);
        }
        return null;
    }

    public int find(String maNV) {
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equals(maNV)) {
                return i;
            }
        }
        return -1;
    }

    public String checkHinhThuc(NhanVien nv) {
        NhanVienBanHang nvBH = new NhanVienBanHang();
        NhanVienKho nvK = new NhanVienKho();
        
        if (nv instanceof NhanVienKho) {
            nvK = (NhanVienKho) nv;
            return nvK.getHinhThuc();
        }
        if (nv instanceof NhanVienBanHang) {
            nvBH = (NhanVienBanHang) nv;
            return nvBH.getHinhThuc();
        }
        return null;
    }

    public void edit() throws FileNotFoundException, IOException {
        String maNV1;
        int choose = 0;
        do {
            System.out.println("**************** UpDate Thong Tin Nhan Vien ***************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Thong Tin Ca Nhan :                                **");
            System.out.println("** 2. Thong Tin Cong Viec :                              **");
            System.out.println("** 3. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    editInfo();

                    break;

                case 2:
                    editCongViec();
                    break;

                case 3:
                    System.out.println("Hen Gap lai !");
                    writeFile();
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 3);
    }

    public void coppyFile(String hoten1, String hoten2) throws FileNotFoundException, IOException {
        File source = new File(hoten1);
        File dest = new File(hoten2);

        InputStream is = null;
        OutputStream os = null;

        try {

            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {

                os.write(buffer, 0, length);
            }

        } finally {

            if (is != null) {
                is.close();
            }

            if (os != null) {
                os.close();
            }
        }
    }

    public void showDsEdit() {
        System.out.println("**************** UpDate Nhan Vien ***************");
        System.out.println("**---------------------------------------------**");
        System.out.println("** Ban Tim theo                                **");
        System.out.println("** 1. MSNV :                                   **");
        System.out.println("** 2. Ho va Ten :                              **");
        System.out.println("** 3. Exit !!                                  **");
        System.out.println("**---------------------------------------------**");
        System.out.println("*************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }

    public void editInfo() throws FileNotFoundException, IOException {
        String msNV1;
        int choose = 0;
        do {
            showDsEdit();
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Nhan Vien Can Edit : ");
                    msNV1 = sc.nextLine();
                    int vitri = find(msNV1);
                    String mssvt = dsNV[vitri].getMaNV();
                    if (vitri > -1) {
                        dsNV[vitri].input();
                        writeFile();
                        load();
                        showInfo();
                    } else {
                        System.out.println("Ban Da Nhap Sai Mssv");
                    }
                    break;

                case 2:
                    System.out.println("Nhap Ho ten Can Edit : ");
                    msNV1 = sc.nextLine();
                    findHoten(msNV1);
                    System.out.println("Nhap Ma NV Can Edit : ");
                    msNV1 = sc.nextLine();
                    int vitri1 = find(msNV1);
                    String mVT1 = dsNV[vitri1].getMaNV();
                    if (find(msNV1) > -1) {
                        dsNV[vitri1].input();
                        writeFile();
                        load();
                        showInfo();
                    } else {
                        System.out.println("Ban Da Nhap Sai Mssv");
                    }
                    break;

                case 3:
                    System.out.println("Hen Gap Lai ! ");

                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 3);
    }

    public void showMenuEditCongViec() {
        System.out.println("**************** UpDate Nhan Vien ***************");
        System.out.println("**---------------------------------------------**");
        System.out.println("** Ban Update theo                             **");
        System.out.println("** 1. Hinh Thuc :                              **");
        System.out.println("** 2. Vi Tri Lam Viec :                        **");
        System.out.println("** 3. Exit !!                                  **");
        System.out.println("**---------------------------------------------**");
        System.out.println("*************************************************");
        System.out.println("Nhap Lua Chon Cua Ban : ");
    }

    public void editCongViec() throws FileNotFoundException, IOException {
        String msNV1;
        int choose = 0, choose1 = 0;
        do {
            showDsEdit();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma Nhan Vien Can Edit : ");
                    msNV1 = sc.nextLine();
                    int vitri = find(msNV1);
                    String mVT = dsNV[vitri].getMaNV();
                    if (vitri > -1) {
//                        dsNV[vitri].input();
                        do {
                            showMenuEditCongViec();
                            choose1 = Integer.parseInt(sc.nextLine());
                            NhanVienKho nv = null;
                            NhanVienBanHang nv1 = null;

                            switch (choose1) {
                                case 1:
                                    if (dsNV[vitri] instanceof NhanVienKho) {
                                        nv = new NhanVienKho(dsNV[vitri].getMaNV(), dsNV[vitri].getGioLam(), dsNV[vitri].getHoTen(), dsNV[vitri].getDiaChi(), dsNV[vitri].getNgaySinh(), dsNV[vitri].getPhone(), dsNV[vitri].getGioiTinh());
                                        System.out.println("Ban muon lam nhan vien voi :");
                                        System.out.println("Hinh thuc :");
                                        System.out.println("1. Part Time");
                                        System.out.println("2. Full Time");
                                        System.out.println("you choose : ");
                                        int choose2 = 0;
                                        choose2 = Integer.parseInt(sc.nextLine());
                                        switch (choose2) {
                                            case 1:
                                                nv.setHinhThuc("Part Time");
                                                break;
                                            case 2:
                                                nv.setHinhThuc("Full Time");
                                                break;
                                            default:
                                                nv.setHinhThuc("Part Time");
                                                System.out.println("Ban Da nhap sai vui long nhap lai !!!");
                                        }
                                        dsNV[vitri] = nv;
                                    }
                                    if (dsNV[vitri] instanceof NhanVienBanHang) {
                                        nv1 = new NhanVienBanHang(dsNV[vitri].getMaNV(), dsNV[vitri].getGioLam(), dsNV[vitri].getHoTen(), dsNV[vitri].getDiaChi(), dsNV[vitri].getNgaySinh(), dsNV[vitri].getPhone(), dsNV[vitri].getGioiTinh());
                                        System.out.println("Ban muon lam nhan vien voi :");
                                        System.out.println("Hinh thuc :");
                                        System.out.println("1. Part Time");
                                        System.out.println("2. Full Time");
                                        System.out.println("you choose : ");
                                        int choose2 = 0;
                                        choose2 = Integer.parseInt(sc.nextLine());
                                        switch (choose2) {
                                            case 1:
                                                nv1.setHinhThuc("Part Time");
                                                break;
                                            case 2:
                                                nv1.setHinhThuc("Full Time");
                                                break;
                                            default:
                                                nv1.setHinhThuc("Part Time");
                                                System.out.println("Ban Da nhap sai vui long nhap lai !!!");
                                        }
                                        dsNV[vitri] = nv1;
                                    }
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;
                                case 2:
                                    System.out.println("Nhap Ma Nhan Vien Can Edit : ");
                                    msNV1 = sc.nextLine();
                                    int vitri1 = find(msNV1);
                                    String mVT1 = dsNV[vitri1].getMaNV();
                                    if (vitri1 > -1) {
                                        System.out.println("Ban muon Update Vi Tri Nhan Vien :");
                                        System.out.println("1. Kho");
                                        System.out.println("2. Ban hang");
                                        System.out.println("you choose : ");
                                        choose1 = Integer.parseInt(sc.nextLine());
                                        NhanVienKho nv2 = null;
                                        NhanVienBanHang nv3 = null;
                                        switch (choose1) {
                                            case 1:
                                                nv2 = new NhanVienKho(checkHinhThuc(dsNV[vitri]), dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                                dsNV[vitri] = nv2;
                                                System.out.println("Hen Gap Lai ! ");

                                                break;
                                            case 2:
                                                nv3 = new NhanVienBanHang(checkHinhThuc(dsNV[vitri]), dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                                dsNV[vitri] = nv3;
                                                System.out.println("Hen Gap Lai ! ");

                                                break;
                                            default:
                                                System.out.println("Ban Da Nhap Sai Xin Vui long Nhap Lai");
                                                break;
                                        }

                                    } else {
                                        System.out.println("Ban Da Nhap Sai Msnv");
                                    }
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;

                                case 3:
                                    System.out.println("Hen Gap Lai ! ");
                                    System.out.println("");
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;

                                default:
                                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                                    break;

                            }
                        } while (choose1 != 3);

                    }
                    break;
                case 2:
                    System.out.println("Nhap Ho ten Can Edit : ");
                    msNV1 = sc.nextLine();
                    findHoten(msNV1);
                    System.out.println("Nhap Ma NV Can Edit : ");
                    msNV1 = sc.nextLine();
                    int vitri1 = find(msNV1);
                    String mVT1 = dsNV[vitri1].getMaNV();
                    if (find(msNV1) > -1) {
                        do {
                            showMenuEditCongViec();
                            choose1 = Integer.parseInt(sc.nextLine());
                            NhanVienKho nv = null;
                            NhanVienBanHang nv1 = null;
                            switch (choose1) {
                                case 1:
                                    if (dsNV[vitri1] instanceof NhanVienKho) {
                                        nv = new NhanVienKho(dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                        System.out.println("Ban muon lam nhan vien voi :");
                                        System.out.println("Hinh thuc :");
                                        System.out.println("1. Part Time");
                                        System.out.println("2. Full Time");
                                        System.out.println("you choose : ");
                                        int choose2 = 0;
                                        choose2 = Integer.parseInt(sc.nextLine());
                                        switch (choose2) {
                                            case 1:
                                                nv.setHinhThuc("Part Time");
                                                break;
                                            case 2:
                                                nv.setHinhThuc("Full Time");
                                                break;
                                            default:
                                                nv.setHinhThuc("Part Time");
                                                System.out.println("Ban Da nhap sai vui long nhap lai !!!");
                                        }
                                        dsNV[vitri1] = nv;
                                    }
                                    if (dsNV[vitri1] instanceof NhanVienBanHang) {
                                        nv1 = new NhanVienBanHang(dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                        System.out.println("Ban muon lam nhan vien voi :");
                                        System.out.println("Hinh thuc :");
                                        System.out.println("1. Part Time");
                                        System.out.println("2. Full Time");
                                        System.out.println("you choose : ");
                                        int choose2 = 0;
                                        choose2 = Integer.parseInt(sc.nextLine());
                                        switch (choose2) {
                                            case 1:
                                                nv1.setHinhThuc("Part Time");
                                                break;
                                            case 2:
                                                nv1.setHinhThuc("Full Time");
                                                break;
                                            default:
                                                nv1.setHinhThuc("Part Time");
                                                System.out.println("Ban Da nhap sai vui long nhap lai !!!");
                                        }
                                        dsNV[vitri1] = nv1;
                                    }
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;
                                case 2:
                                    System.out.println("Nhap Ma Nhan Vien Can Edit : ");
                                    msNV1 = sc.nextLine();
                                    vitri1 = find(msNV1);
                                    mVT1 = dsNV[vitri1].getMaNV();
                                    if (vitri1 > -1) {
                                        System.out.println("Ban muon Update Vi Tri Nhan Vien :");
                                        System.out.println("1. Kho");
                                        System.out.println("2. Ban hang");
                                        System.out.println("you choose : ");
                                        choose1 = Integer.parseInt(sc.nextLine());
                                        NhanVienKho nv2 = null;
                                        NhanVienBanHang nv3 = null;
                                        switch (choose1) {
                                            case 1:
                                                nv2 = new NhanVienKho(checkHinhThuc(dsNV[vitri1]), dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                                dsNV[vitri1] = nv2;
                                                System.out.println("Hen Gap Lai !");

                                                break;
                                            case 2:
                                                nv3 = new NhanVienBanHang(checkHinhThuc(dsNV[vitri1]), dsNV[vitri1].getMaNV(), dsNV[vitri1].getGioLam(), dsNV[vitri1].getHoTen(), dsNV[vitri1].getDiaChi(), dsNV[vitri1].getNgaySinh(), dsNV[vitri1].getPhone(), dsNV[vitri1].getGioiTinh());
                                                dsNV[vitri1] = nv3;
                                                System.out.println("Hen Gap Lai !");

                                                break;
                                            default:
                                                System.out.println("Ban Da Nhap Sai Xin Vui long Nhap Lai");
                                                break;
                                        }

                                    } else {
                                        System.out.println("Ban Da Nhap Sai Msnv");
                                    }
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;

                                case 3:
                                    System.out.println("Hen Gap Lai ! ");
                                    System.out.println("");
                                    writeFile();
                                    load();
                                    showInfo();
                                    break;
                                default:
                                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                                    break;

                            }

                        } while (choose1 != 3);
                    }
                    break;
                case 3:
                    System.out.println("Hen Gap Lai ! ");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!! ");
            }
        } while (choose1 != 3);
    }

    public NhanVien findNv(String maNV) {
        NhanVien nv = null;
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV) && dsNV[i] instanceof NhanVienKho) {
                nv = new NhanVienKho();
                nv = dsNV[i];
            }
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV) && dsNV[i] instanceof NhanVienBanHang) {
                nv = new NhanVienBanHang();
                nv = dsNV[i];
            }
        }

        return nv;
    }

    public void findMaNV(String maNV) {
        boolean check = false;
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV)) {
                dsNV[i].showInfo();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }

    public void findHoten(String name) {
        boolean check = false;
        String format1 = "|%1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-1s|\n";

        String format2 = " %1$-20s%2$-20s%3$-20s%4$-20s%5$-15s%6$-15s%7$-15s%8$-1s \n";
        System.out.format(format2, "", "", "              DANH SACH NHAN VIEN       ", "", "", "", "", "    ");
        System.out.format(format2, "", "", "              *******************       ", "", "", "", "", "    ");
        System.out.println("");
        System.out.format(format1, "Ma NV", "Ho Ten", "Gioi Tinh", "Dia Chi", "Phone", "Hinh Thuc", "Vi Tri");
        System.out.println("========================================================================================================================");
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getHoTen().equalsIgnoreCase(name) || dsNV[i].getHoTen().indexOf(name, 0) > -1 || name.indexOf(dsNV[i].getHoTen(), 0) > -1) {
                if (dsNV[i] instanceof NhanVienKho) {
                    dsNV[i].showInfo();
                    check = true;
                }
                if (dsNV[i] instanceof NhanVienBanHang) {
                    dsNV[i].showInfo();
                    check = true;
                }
            }
        }
        System.out.println("");
        System.out.println("");
        if (!check) {
            System.out.println("Khong tim thay !!!");
        }
    }

    public void findViTri(String vitri) throws IOException {
        boolean check = false;
        setDsNhanVien(readFile());
        for (NhanVien nv : dsNV) {
            if (nv instanceof NhanVienKho) {
                if (((NhanVienKho) nv).getViTri().equalsIgnoreCase(vitri)) {
                    check = true;
                    nv.showInfo();
                }
            }
            if (nv instanceof NhanVienBanHang) {
                if (((NhanVienBanHang) nv).getViTri().equalsIgnoreCase(vitri)) {
                    check = true;
                    nv.showInfo();
                }

            }
        }
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

    @Override
    public NhanVien[] readFile() throws IOException {
        NhanVien[] ds = new NhanVien[indexFile("DsNV.txt")];
        int i = 0;
        File f = new File("DsNV.txt");
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                NhanVien nv = null;
                if (data[7].equalsIgnoreCase("Kho")) {
                    nv = new NhanVienKho(data[6], data[0], Float.parseFloat(data[8]), data[1], data[4], data[2], data[5], data[3]);
                }
                if (data[7].equalsIgnoreCase("Ban hang")) {
                    nv = new NhanVienBanHang(data[6], data[0], Float.parseFloat(data[8]), data[1], data[4], data[2], data[5], data[3]);
                }
                ds[i] = nv;
                i++;
            }
        } else {
            f.createNewFile();
        }
        return ds;
    }

    @Override
    public void writeFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DsNV.txt"), true);
        for (NhanVien nv : dsNV) {
            if (nv instanceof NhanVienKho) {
                String data = nv.getMaNV() + "," + nv.getHoTen() + "," + nv.getNgaySinh() + "," + nv.getGioiTinh() + "," + nv.getDiaChi() + "," + nv.getPhone() + "," + ((NhanVienKho) nv).getHinhThuc() + "," + ((NhanVienKho) nv).getViTri() + "," + nv.getGioLam();
                out.println(data);
            }
            if (nv instanceof NhanVienBanHang) {
                String data = nv.getMaNV() + "," + nv.getHoTen() + "," + nv.getNgaySinh() + "," + nv.getGioiTinh() + "," + nv.getDiaChi() + "," + nv.getPhone() + "," + ((NhanVienBanHang) nv).getHinhThuc() + "," + ((NhanVienBanHang) nv).getViTri() + "," + nv.getGioLam();
                out.println(data);
            }

        }
    }

    @Override
    public void deleteFile(String nameFile) {
        File file = new File(nameFile);
        file.delete();
    }

}
