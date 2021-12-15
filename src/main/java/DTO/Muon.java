/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author dell
 */
public class Muon {
    private String IDMuon;
    private String PhoneNumber;
    private String NgayTra;
    private String NgayMuon;
    private String MaSach;
    private String UserName;

    public void setIDMuon(String IDMuon) {
        this.IDMuon = IDMuon;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getIDMuon() {
        return IDMuon;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getUserName() {
        return UserName;
    }

    public Muon(String IDMuon, String PhoneNumber, String NgayTra, String NgayMuon, String MaSach, String UserName) {
        this.IDMuon = IDMuon;
        this.PhoneNumber = PhoneNumber;
        this.NgayTra = NgayTra;
        this.NgayMuon = NgayMuon;
        this.MaSach = MaSach;
        this.UserName = UserName;
    }
}
