/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.Tra;
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
 * @author Administrator
 */
public class Tra_DAO {
    public Tra_DAO () {
    
}
    public List<Tra> DanhSachTra(String UserName) throws SQLException{
        List<Tra> dsTra=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from tra where UserName=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, UserName);
            ResultSet rs= stm.executeQuery();
             while(rs.next()){
                Tra a=new Tra(rs.getInt("IDTra"),rs.getString("PhoneNumber"),rs.getString("NgayTra"),rs.getString("NgayMuon"),rs.getString("MaSach"),rs.getString("UserName"),rs.getString("TinhTrang"));
                dsTra.add(a);
            }
            conn.commit();
        }
        return dsTra;
    }
    
    public boolean ThemTra(String UserName,String MaSach,String NgayMuon,String NgayTra,String PhoneNumber,String TinhTrang) throws SQLException{
        boolean KQ=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="insert into tra(MaSach,UserName,PhoneNumber,NgayTra,NgayMuon,TinhTrang)\n" +
                         "select  s.MaSach,q.UserName,q.PhoneNumber,?,?,?\n" +
                         "from muon q,sach s\n" +
                         "where q.UserName=? and s.MaSach=? \n" ;
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(4, UserName);
            stm.setString(5,MaSach);
            stm.setString(1, NgayTra);
            stm.setString(2, NgayMuon);
            stm.setString(3,TinhTrang);
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
