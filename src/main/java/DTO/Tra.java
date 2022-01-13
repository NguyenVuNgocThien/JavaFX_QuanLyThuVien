/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class Tra {
     private int IDTra;
    private String PhoneNumber1;
    private String NgayTra1;
    private String NgayMuon1;
    private String MaSach1;
    private String UserName1;
    private String TinhTrang; 

    public void setIDTra(int IDTra) {
        this.IDTra = IDTra;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber1 = PhoneNumber;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra1 = NgayTra;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon1 = NgayMuon;
    }

    public void setMaSach(String MaSach) {
        this.MaSach1 = MaSach;
    }

    public void setUserName(String UserName) {
        this.UserName1 = UserName;
    }

    public int getIDTra() {
        return IDTra;
    }

    public String getPhoneNumber() {
        return PhoneNumber1;
    }

    public String getNgayTra() {
        return NgayTra1;
    }

    public String getNgayMuon() {
        return NgayMuon1;
    }

    public String getMaSach() {
        return MaSach1;
    }

    public String getUserName() {
        return UserName1;
    }
    public String getTinhTrang(){ 
        return TinhTrang; 
    }

    public Tra(int IDTra, String PhoneNumber, String NgayTra, String NgayMuon, String MaSach, String UserName, String TinhTrang) {
        this.IDTra = IDTra;
        this.PhoneNumber1 = PhoneNumber;
        this.NgayTra1 = NgayTra;
        this.NgayMuon1 = NgayMuon;
        this.MaSach1 = MaSach;
        this.UserName1 = UserName;
        this.TinhTrang = TinhTrang;
    }
    
}
