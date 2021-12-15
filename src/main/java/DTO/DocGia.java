/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.*;
/**
 *
 * @author dell
 */
public class DocGia {
        private String UserName;
        private String Pass;
        private String TenDocGia;
        private String NgaySinh;
        private String ChucVu;
        private String TinhTrangThe;
        private String Gmail;
        private String GioiTinh;
        private String SDT;
        private String Khoa;
   
    public DocGia(String TenDocGia, String NgaySinh, String ChucVu, String TinhTrangThe, String Gmail, String GioiTinh, String SDT, String Khoa) {
        this.TenDocGia = TenDocGia;
        this.NgaySinh = NgaySinh;
        this.ChucVu = ChucVu;
        this.TinhTrangThe = TinhTrangThe;
        this.Gmail = Gmail;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.Khoa = Khoa;
    }

    public DocGia() {
        this.UserName=this.Pass=this.TenDocGia=this.NgaySinh=this.ChucVu=this.TinhTrangThe=this.Gmail=this.GioiTinh=this.SDT=this.Khoa="";
     }

    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public String getTenDocGia() {
        return TenDocGia;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getTinhTrangThe() {
        return TinhTrangThe;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setTenDocGia(String TenDocGia) {
        this.TenDocGia = TenDocGia;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setTinhTrangThe(String TinhTrangThe) {
        this.TinhTrangThe = TinhTrangThe;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

   

  
   

    
}
