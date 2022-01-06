/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Sach_DAO {
    public Sach_DAO(){
        
    }
    public List<Sach> DanhSachSach() throws SQLException{
        List<Sach> dsSach=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from sach";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Sach a=new Sach(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TenTacGia"),rs.getString("MoTaSach"),
                rs.getString("PhatHanh"),rs.getString("NoiPhatHanh"),rs.getString("TinhTrang"),rs.getString("LoaiSach"));
                dsSach.add(a);
            }
        }
        return dsSach;
    }
    public List<Sach> TimKiemSach(String input) throws SQLException{
        List<Sach> dsSach=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from sach where TenTacGia=? or MaSach=? or TenSach=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, input);
            stm.setString(2, input);
            stm.setString(3, input);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
            Sach a=new Sach(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TenTacGia"),rs.getString("MoTaSach"),
                rs.getString("PhatHanh"),rs.getString("NoiPhatHanh"),rs.getString("TinhTrang"),rs.getString("LoaiSach"));
            dsSach.add(a);
            }
            conn.commit();
        }
        return dsSach;
    }
}
