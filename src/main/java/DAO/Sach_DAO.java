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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public boolean KTMaSach(String MaSach){
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from sach ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                 if(rs.getString("MaSach").equals(MaSach))
                     kq=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public boolean ThemSach(Sach s){
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="insert into Sach(MaSach,TenSach,TenTacGia,TinhTrang) values(?,?,?,?)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, s.getMaSach());
            stm.setString(2, s.getTenSach());
            stm.setString(4, s.getTinhTrang());
            stm.setString(3, s.getTenTacGia());
            stm.executeUpdate();
            kq=true;
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAO.class.getName()).log(Level.SEVERE, null, ex);
            kq=false;
        }
        return kq;
    }
    public boolean SuaSach(Sach s){
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="update sach"
                    + "   set TenSach=?,TenTacGia=?"
                    + "   where MaSach=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(3, s.getMaSach());
            stm.setString(1, s.getTenSach());
            stm.setString(2, s.getTenTacGia());
            stm.executeUpdate();
            kq=true;
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAO.class.getName()).log(Level.SEVERE, null, ex);
            kq=false;
        }
        return kq;
    }
    public boolean XoaSach(String MaSach){
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="delete from sach"
                    + "   where MaSach=? and TinhTrang<>\"Borrowed\"\n"
                    + "   and not exists(select * from yeucau where MaSach=?)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, MaSach);
            stm.setString(2, MaSach);
            stm.executeUpdate();
            kq=true;
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAO.class.getName()).log(Level.SEVERE, null, ex);
            kq=false;
        }
        return kq;
    }
    public boolean CapNhatSachDangMuon(String MaSach){
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="update sach \n" +
                         "set TinhTrang=\"Borrowed\"\n" +
                         "where sach.MaSach=? and exists(select *from muon where sach.MaSach=muon.MaSach)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, MaSach);
            stm.executeUpdate();
            kq=true;
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAO.class.getName()).log(Level.SEVERE, null, ex);
            kq=false;
        }
        return kq;
    }
}
