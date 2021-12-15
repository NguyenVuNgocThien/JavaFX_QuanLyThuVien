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
public class Sach {

    private String MaSach;
    private String TenSach;
    private String TenTacGia;
    private String MoTaSach;
    private String PhatHanh;
    private String NoiPhatHanh;
    private String TinhTrang;
    private String LoaiSach;

    public Sach(String MaSach, String TenSach, String TenTacGia, String MoTaSach, String PhatHanh, String NoiPhatHanh, String TinhTrang, String LoaiSach) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTacGia = TenTacGia;
        this.MoTaSach = MoTaSach;
        this.PhatHanh = PhatHanh;
        this.NoiPhatHanh = NoiPhatHanh;
        this.TinhTrang = TinhTrang;
        this.LoaiSach = LoaiSach;
    }
    public Sach(){
        this.MaSach=this.TenSach=this.TenTacGia=this.MoTaSach=this.PhatHanh=this.NoiPhatHanh=this.TinhTrang=this.LoaiSach="";
    }
    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public String getMoTaSach() {
        return MoTaSach;
    }

    public String getPhatHanh() {
        return PhatHanh;
    }

    public String getNoiPhatHanh() {
        return NoiPhatHanh;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public String getLoaiSach() {
        return LoaiSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }

    public void setMoTaSach(String MoTaSach) {
        this.MoTaSach = MoTaSach;
    }

    public void setPhatHanh(String PhatHanh) {
        this.PhatHanh = PhatHanh;
    }

    public void setNoiPhatHanh(String NoiPhatHanh) {
        this.NoiPhatHanh = NoiPhatHanh;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public void setLoaiSach(String LoaiSach) {
        this.LoaiSach = LoaiSach;
    }
   
}
