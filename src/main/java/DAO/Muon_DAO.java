/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Muon;
import DTO.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Muon_DAO {
    public Muon_DAO(){
        
    }
    public List<Muon> DanhSachMuon(String UserName) throws SQLException{
        List<Muon> dsMuon=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from muon where UserName=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, UserName);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Muon a=new Muon(rs.getInt("IDMuon"),rs.getString("PhoneNumber"),rs.getString("NgayTra"),rs.getString("NgayMuon"),rs.getString("MaSach"),rs.getString("UserName"));
                dsMuon.add(a);
            }
            conn.commit();
        }
        return dsMuon;
    }
    public int DemSLSach(String UserName) throws SQLException{
        int SL=0;
        try(Connection conn=ConnectionClass.getConn()){
            String query="select count(IDMuon) as SL from muon where UserName=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, UserName);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
            SL=Integer.parseInt( rs.getString("SL"));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(SL);
        return SL;
    }
    public boolean XoaYeuCau(String MaSach) throws SQLException{
        boolean KQ=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="delete from yeucau where MaSach=? ";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1,MaSach);
            stm.executeUpdate();
            KQ=true;
            conn.commit();
        }
        catch(SQLException ex){
            ex.printStackTrace();
            KQ=false;
        }
        return KQ;
    }
    public boolean ThemMuon(String UserName,String MaSach,String NgayMuon,String NgayTra) throws SQLException{
        boolean KQ=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="insert into muon(PhoneNumber,NgayTra,NgayMuon,MaSach,UserName)\n" +
                         "select  q.SDT,?,?,s.MaSach,q.UserName\n" +
                         "from quanlydocgia q,sach s\n" +
                         "where q.UserName=? and s.MaSach=? \n" +
                         "and exists(select * from yeucau where UserName=q.UserName and MaSach=s.MaSach)\n" +
                         "and not exists(select * from muon where  MaSach=s.MaSach)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(3, UserName);
            stm.setString(4,MaSach);
            stm.setString(1, NgayTra);
            stm.setString(2, NgayMuon);
            stm.executeUpdate();
            KQ=true;
            conn.commit();
        }
        catch(SQLException ex){
            ex.printStackTrace();
            KQ=false;
        }
        
        return KQ;
    }
}
