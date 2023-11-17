/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QL_Cua_Hang_Ban_Dien_Thoai;

/**
 * @Doan: Quan Li Cua Hang Ban Dien Thoai
 * @NamHoc :HK2_2022-2023
 * @author: Pham Quang Huy 3120480031 - Phan Nguyen Quoc Nam 3120480052 - Nguyen Hung Viet 3120480113
 */

public class GiamDoc extends ThanhVien{
    
    private String chucvu = "Giam Doc";
    private String nameCH = "Cua Hang Dien Thoai ABC";

    public String getChucVu() {
        return chucvu;
    }

    public GiamDoc() {
    }

    public GiamDoc(String hoten, String diachi, String ngaysinh, String phone, String gioitinh) {
        super(hoten, diachi, ngaysinh, phone, gioitinh);
    }

    public void setChucVu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getNameCty() {
        return nameCH;
    }

    public void setNameCty(String nameCty) {
        this.nameCH = nameCH;
    }

}
