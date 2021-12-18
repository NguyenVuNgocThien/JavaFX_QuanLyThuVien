/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.YeuCau;
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
public class YeuCau_DAO {
    public YeuCau_DAO(){
        
    }
    public List<YeuCau> DSYeuCau(String UserName) throws SQLException{
        List<YeuCau> yc=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from yeucau where UserName=?";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, UserName);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                YeuCau a=new YeuCau(rs.getString("UserName"), rs.getString("MaSach"));
                yc.add(a);
            }
            conn.commit();
        }
        return yc;
    }
 
    
    public boolean ThemYeuCau(String UserName,String MaSach) throws SQLException{
        boolean KQ=false;
        try(Connection conn=ConnectionClass.getConn()){
            String query="insert into yeucau(UserName,MaSach) values(?,?)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, UserName);
            stm.setString(2, MaSach);
            stm.executeUpdate();
            KQ=true;
            conn.commit();
        }
        return KQ;
    }
}
