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
}
