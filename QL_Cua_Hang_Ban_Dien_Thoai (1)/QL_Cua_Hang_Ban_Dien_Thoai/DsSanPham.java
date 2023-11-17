/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;


import static QL_Cua_Hang_Ban_Dien_Thoai.DsNhanVien.sc;
import java.awt.BorderLayout;
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

public class DsSanPham {
    
    PhuKien[] dsphukien;
    DienThoai[] dsdienthoai;

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

    public void inputPhuKien() throws FileNotFoundException {
        System.out.println("Nhap So Luong Phu Kien Muon Nhap Vao :");
        int n = Integer.parseInt(sc.nextLine());
        dsphukien = new PhuKien[n];
        for (int i = 0; i < n; i++) {
            dsphukien[i] = new PhuKien();
            dsphukien[i].input();
        }
        writeFilePhuKien();
    }

    public void load() throws IOException {
        setDsDienThoai(readFileDienThoai());
        setDsPhuKien(readFilePhuKien());
    }

    public void inputDienThoai() throws FileNotFoundException {
        System.out.println("Nhap So Luong Dien Thoai Muon Them Vao :");
        int n = Integer.parseInt(sc.nextLine());
        dsdienthoai = new DienThoai[n];
        for (int i = 0; i < n; i++) {
            dsdienthoai[i] = new DienThoai();
            dsdienthoai[i].input();
        }
        writeFileDienThoai();
    }

    public void showDsPhuKien() throws IOException {
        load();
        System.out.println("");
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Phu Kien", "");
        System.out.format(format, "", "*********", "");
        System.out.println("");

        System.out.format(format1, "Ma PK", "Ten PK", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsphukien.length; i++) {
            System.out.format(format, dsphukien[i].getMaPhuKien(), dsphukien[i].getTenPhuKien(), dsphukien[i].getGia());
            System.out.println("----------------------------------------------------");
        }
    }

     public void showDsDienThoai() throws IOException {
        System.out.println("");
        load();
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Dien Thoai", "");
        System.out.format(format, "", "********", "");
        System.out.println("");
        System.out.format(format1, "Ma DT", "Ten DT", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsdienthoai.length; i++) {
            System.out.format(format, dsdienthoai[i].getMaDienThoai(), dsdienthoai[i].getTenDienThoai(), dsdienthoai[i].getGia());
            System.out.println("----------------------------------------------------");
        }
    }

    public void addPhuKien(PhuKien pk) throws FileNotFoundException {
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length + 1);
        dsphukien[dsphukien.length - 1] = pk;
        writeFilePhuKien();
    }

    public void addPhuKien() throws FileNotFoundException, IOException {
        PhuKien pk = new PhuKien();
         do {            
            System.out.println("Nhap Thong Tin Phu Kien Can Them : ");
            pk.input();
            if(checkPhuKien(pk.getMaPhuKien())){
                addPhuKien(pk);
                break;
            }else{
                System.out.println("Ma Phu Kien da ton tai !!! Vui long nhap lai");
                System.out.println("");
            }
        } while (true);
    }

    public void addPhuKien(PhuKien pk, int index) throws FileNotFoundException {
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length + 1);
        if (index <= dsphukien.length) {
            for (int i = dsphukien.length - 1; i > index; i--) {
                dsphukien[i] = dsphukien[i - 1];
            }
            dsphukien[index] = pk;
            writeFilePhuKien();
        } else {
            System.out.println("khong them dc");
        }
    }

    public PhuKien[] removePhuKien(int index) throws FileNotFoundException {
        for (int i = index; i < dsphukien.length - 1; i++) {
            dsphukien[i] = dsphukien[i + 1];
        }
        dsphukien = Arrays.copyOf(dsphukien, dsphukien.length - 1);
        writeFilePhuKien();
        return dsphukien;
    }

    public PhuKien[] removePhuKien(PhuKien pk) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(pk.getMaPhuKien())) {
                check = true;
                break;
            }
        }
        if (check) {
            return removePhuKien(i);
        }
        return null;
    }

    public PhuKien[] removePhuKien(String maPK) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) {
                check = true;
                break;
            }
        }
        if (check) {
            return removePhuKien(i);
        }
        return null;
    }

    public void addDienThoai(DienThoai dt) throws FileNotFoundException {
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length + 1);
        dsdienthoai[dsdienthoai.length - 1] = dt;
        writeFileDienThoai();
    }

    public void addDienThoai() throws FileNotFoundException, IOException {
        DienThoai dt = new DienThoai();
        do {            
            System.out.println("Nhap Thong Tin Dien Thoai Can Them : ");
            dt.input();
            if(checkDienThoai(dt.getMaDienThoai())){
                addDienThoai(dt);
                break;
            }else{
                System.out.println("Ma Dien Thoai da ton tai !!! Vui long nhap lai ! ");
                System.out.println("");
            }
        } while (true);
    }

    public void addDienThoai(DienThoai dt, int index) throws FileNotFoundException {
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length + 1);
        if (index <= dsdienthoai.length) {
            for (int i = dsdienthoai.length - 1; i > index; i--) {
                dsdienthoai[i] = dsdienthoai[i - 1];
            }
            dsdienthoai[index] = dt;
            writeFileDienThoai();
        } else {
            System.out.println("khong them dc");
        }
    }

    public void removeDienThoai() throws FileNotFoundException{
        String maDT;
        int choose = 0;
        do {
            System.out.println("**************** UpDate Dien Thoai***************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma DT     :                              **");
            System.out.println("** 2. Ten DT  :                                **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma DT Can Xoa : ");
                    maDT = sc.nextLine();
                    removeDienThoai(maDT);
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
                    removeDienThoai(maDT);
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
    public void removePhuKien() throws FileNotFoundException{
        String maPK;
        int choose = 0;
        do {
            System.out.println("**************** UpDate Phu Kien ***************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma PK        :                           **");
            System.out.println("** 2. Ten PK        :                          **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    System.out.println("Nhap Ma PK Can Xoa : ");
                    maPK = sc.nextLine();
                    removePhuKien(maPK);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Nhap Ten PK Can Xoa : ");
                    maPK = sc.nextLine();
                    findTenPhuKien(maPK);
                    System.out.println("Nhap Ma PK Can Xoa : ");
                    maPK = sc.nextLine();
                    removePhuKien(maPK);
                    System.out.println("");
                    System.out.println("Xoa Thanh Cong ! ");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Hen Gap Lai ! ");
                    System.out.println("");
                    break;
                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;
            }
        } while (choose != 3);
    }
    public void suaDienThoai() throws FileNotFoundException, IOException{
        String maDT;
        load();
        int choose = 0;
        do {
            System.out.println("**************** UpDate Dien Thoai ***************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma DT     :                              **");
            System.out.println("** 2. Ten DT  :                                **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    showDsDienThoai();
                    System.out.println("Nhap Ma DT Can Sua : ");
                    maDT = sc.nextLine();
                    DienThoai m = new DienThoai();
                    m.input();
                    removeDienThoai(findDienThoai(maDT));
                    addDienThoai(m);
//                    showDsDienThoai();
                    writeFileDienThoai();
                    load();
                    break;
                case 2:
                    showDsDienThoai();
                    System.out.println("Nhap Ten DT Can Sua : ");
                    maDT = sc.nextLine();
                    findTenDienThoai(maDT);
                    System.out.println("Nhap Ma DT Can Sua : ");
                    DienThoai m1 = new DienThoai();
                    m1.input();
                    removeDienThoai(findDienThoai(maDT));
                    addDienThoai(m1);
                    writeFileDienThoai();
                    load();
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
    public void suaPhuKien() throws FileNotFoundException, IOException{
        String maPK;
        load();
        int choose = 0;
        do {
            System.out.println("**************** UpDate Phu Kien ***************");
            System.out.println("**---------------------------------------------**");
            System.out.println("** Ban Tim theo                                **");
            System.out.println("** 1. Ma PK :                                  **");
            System.out.println("** 2. Ten PK :                                 **");
            System.out.println("** 3. Exit !!                                  **");
            System.out.println("**---------------------------------------------**");
            System.out.println("*************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    showDsPhuKien();
                    System.out.println("Nhap Ma PK Can Sua : ");
                    maPK = sc.nextLine();
                    PhuKien m = new PhuKien();
                    m.input();
                    removePhuKien(findMaPhuKien(maPK));
                    addPhuKien(m);
                    writeFilePhuKien();
                    break;
                case 2:
                    showDsPhuKien();
                    System.out.println("Nhap Ten PK Can Sua : ");
                    maPK = sc.nextLine();
                    findTenPhuKien(maPK);
                    System.out.println("Nhap Ma PK Can sua : ");
                    maPK = sc.nextLine();
                    PhuKien m1 = new PhuKien();
                    m1.input();
                    removePhuKien(findMaPhuKien(maPK));
                    addPhuKien(m1);
                    writeFilePhuKien();
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
    public DienThoai[] removeDienThoai(int index) throws FileNotFoundException {
        for (int i = index; i < dsdienthoai.length - 1; i++) {
            dsdienthoai[i] = dsdienthoai[i + 1];
        }
        dsdienthoai = Arrays.copyOf(dsdienthoai, dsdienthoai.length - 1);
        writeFileDienThoai();
        return dsdienthoai;
    }

    public DienThoai[] removeDienThoai(DienThoai dt) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(dt.getMaDienThoai())) {
                check = true;
                break;
            }
        }
        if (check) {
            return removeDienThoai(i);
        }
        return null;
    }

    public DienThoai[] removeDienThoai(String maDT) throws FileNotFoundException {
        int i = 0;
        boolean check = false;
        for (; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(maDT)) {
                check = true;
                break;
            }
        }
        if (check) {
            return removeDienThoai(i);
        }
        return null;
    }

    public int findMaPhuKien(String maPK) throws IOException {
        load();
        for (int i = 0; i < dsphukien.length; i++) {
            if (dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) {
                return i;
            }
        }
        return -1;
    }

    public int findDienThoai(String dienthoai) throws IOException {
        load();
        for (int i = 0; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(dienthoai)) {
                return i;
            }
        }
        return -1;
    }

    public void findTenDienThoai(String name) {
        boolean check = false;
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Dien Thoai ", "");
        System.out.format(format, "", "********", "");
        System.out.println("");
        System.out.format(format1, "Ma DT", "Ten DT", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsdienthoai.length; i++) {
            if (dsdienthoai[i].getTenDienThoai().equalsIgnoreCase(name) || dsdienthoai[i].getTenDienThoai().indexOf(name, 0) > -1 || name.indexOf(dsdienthoai[i].getTenDienThoai(), 0) > -1) {
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
    
    public void findTenPhuKien(String name) {
        boolean check = false;
        String format1 = "|%1$-20s%2$-20s%3$-1s|\n";
        String format = " %1$-20s%2$-20s%3$-20s \n";
        System.out.format(format, "", "Danh Sach Phu Kien ", "");
        System.out.format(format, "", "*********", "");
        System.out.println("");
        System.out.format(format1, "Ma PK", "Ten PK", "Gia Tien");
        System.out.println("====================================================");
        for (int i = 0; i < dsphukien.length; i++) {
            if (dsphukien[i].getTenPhuKien().equalsIgnoreCase(name) || dsphukien[i].getTenPhuKien().indexOf(name, 0) > -1 || name.indexOf(dsphukien[i].getTenPhuKien(), 0) > -1) {
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
    
    public void editDienThoai() throws FileNotFoundException, IOException{
        String msnv1;
        int choose = 0;
        do {
            System.out.println("******************** UpDate Dien Thoai ********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Them DT :                                          **");
            System.out.println("** 2. Xoa DT :                                           **");
            System.out.println("** 3. Sua DT :                                           **");
            System.out.println("** 4. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    addDienThoai();
                    load();
                    showDsDienThoai();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    load();
                    showDsDienThoai();
                    removeDienThoai();
                    load();
                    showDsDienThoai();
                    System.out.println("");
                    System.out.println("");
                    break;
               case 3:
                    suaDienThoai();
                    load();
                    showDsDienThoai();
                    System.out.println("");
                    System.out.println("");
                    break;
               case 4:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
//                    writeFile();
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 4);
    }
    
    public void editPhuKien() throws IOException{
        String msnv1;
        int choose = 0;
        do {
            System.out.println("******************** UpDate Phu Kien **********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Them PK :                                          **");
            System.out.println("** 2. Xoa PK :                                           **");
            System.out.println("** 3. Sua PK :                                           **"); 
            System.out.println("** 4. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    addPhuKien();
                    load();
                    showDsPhuKien();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    showDsPhuKien();
                    removePhuKien();
                    load();
                    showDsPhuKien();
                    System.out.println("");
                    System.out.println("");
                    break;
               case 3:
                    suaPhuKien();
                    load();
                    showDsPhuKien();
                    System.out.println("");
                    System.out.println("");
                    break;
               case 4:
                    System.out.println("Hen Gap Lai !");
                    System.out.println("");
//                    writeFile();
                    break;

                default:
                    System.err.println("Ban Da Nhap Sai Vui Long Nhap Lai !!!");
                    break;

            }
        } while (choose != 4);
    }
    
    public void edit() throws FileNotFoundException, IOException {
        String msnv1;
        int choose = 0;
        do {
            System.out.println("******************* UpDate Danh Sach **********************");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("** Ban muon UpDate                                       **");
            System.out.println("** 1. Dien Thoai :                                       **");
            System.out.println("** 2. Phu Kien :                                         **");
            System.out.println("** 3. Exit !!                                            **");
            System.out.println("**-------------------------------------------------------**");
            System.out.println("***********************************************************");
            System.out.println("Nhap Lua Chon Cua Ban : ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch (choose) {
                case 1:
                    editDienThoai();
                    
                    break;

                case 2:
                    editPhuKien();
                    
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
    
    public boolean checkDienThoai(String maDT) throws IOException{
            setDsDienThoai(readFileDienThoai());
            for(int i=0;i<dsdienthoai.length;i++){
                if(dsdienthoai[i].getMaDienThoai().equalsIgnoreCase(maDT)) return false;
            }
            return true;
    }
    public boolean checkPhuKien(String maPK) throws IOException{
         setDsPhuKien(readFilePhuKien());
            for(int i=0;i<dsphukien.length;i++){
                if(dsphukien[i].getMaPhuKien().equalsIgnoreCase(maPK)) return false;
            }
            return true;
    }
    public float TongTien() throws IOException{
        load();
        float s = 0;
        for(int i=0;i<dsdienthoai.length;i++){
            s+=dsdienthoai[i].TongTien();
        }
        for(int i=0;i<dsphukien.length;i++){
            s+=dsphukien[i].TongTien();
        }
        return s;
    }
    
//    doc ghi file

    public void writeFilePhuKien() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DsPK.txt"), true);
        for (PhuKien pk : dsphukien) {
            String data = pk.getMaPhuKien() + "," + pk.getTenPhuKien() + "," + pk.getGia() + "," + pk.getSoLuong() + ","  + pk.getNgayNhapHang();
            out.println(data);
        }
    }

    public void writeFileDienThoai() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("DsDT.txt"), true);
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

    public PhuKien[] readFilePhuKien() throws IOException {
        PhuKien[] ds = new PhuKien[indexFile("DsPK.txt")];
        int i = 0;
        File f = new File("DsPK.txt");
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

    public DienThoai[] readFileDienThoai() throws IOException {
        DienThoai[] ds = new DienThoai[indexFile("DsDT.txt")];
        int i = 0;
        File f = new File("DsDT.txt");
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
