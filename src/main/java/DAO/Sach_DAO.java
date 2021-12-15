/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Sach;
import java.sql.Connection;
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
}