/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.DocGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
/**
 *
 * @author dell
 */
public class DocGia_DAO {
    
    public  DocGia_DAO(){
        
    }
    public List<DocGia> DanhSachDocGia() throws SQLException{
        List<DocGia> dsDocGia=new ArrayList<>();
        try(Connection conn=ConnectionClass.getConn()){
        String query="select * from quanlydocgia";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            DocGia a=new DocGia(rs.getString("TenDocGia"), rs.getString("NgaySinh"), rs.getString("ChucVu"), 
                    rs.getString("TinhTrangThe"), rs.getString("Gmail"),rs.getString("GioiTinh"),rs.getString("SDT"),rs.getString("Khoa"));
          
            dsDocGia.add(a);
        }
        }
        
        return dsDocGia;
    }
    public int DangNhap_DAO(String UserName,String Pass) throws SQLException{
        int isDangNhap=0;
        try(Connection conn=ConnectionClass.getConn()){
            String query="Select * from quanlydocgia ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                if(rs.getString("UserName").equals(UserName) && rs.getString("Pass").equals(Pass)){
                    if(rs.getString("ChucVu").equals("Admin")){
                        isDangNhap=1;
                    }
                    else
                        isDangNhap=2;
                    break;
                }
            }
        }
        System.out.println(isDangNhap);
        return isDangNhap;
    }
    public boolean DangKy(DocGia dg) {
        boolean kq=false;
        try(Connection conn=ConnectionClass.getConn()){
            //String query=String.format("insert into quanlydocgia"+
             //                          " values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
               //     ,dg.getUserName(),dg.getPass(),dg.getTenDocGia(),dg.getNgaySinh(),dg.getChucVu()
                 //   ,dg.getTinhTrangThe(),dg.getGmail(),dg.getGioiTinh(),dg.getSDT(),dg.getKhoa());
            String query="insert into quanlydocgia(UserName,Pass,TenDocGia,NgaySinh,ChucVu,TinhTrangThe,Gmail,GioiTinh,SDT,Khoa) values(?,?,?,?,?,?,?,?,?,?)";
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement(query);
            stm.setString(1, dg.getUserName());
            stm.setString(2, dg.getPass());
            stm.setString(3, dg.getTenDocGia());
            stm.setString(4, dg.getNgaySinh());
            stm.setString(5, dg.getChucVu());
            stm.setString(6, dg.getTinhTrangThe());
            stm.setString(7, dg.getGmail());
            stm.setString(8, dg.getGioiTinh());
            stm.setString(9, dg.getSDT());
            stm.setString(10, dg.getKhoa());
            stm.executeUpdate();
            kq=true;
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kq;
    }
    public int KiemTraTenDangNhap(String UserName){
        int KQ=0;
        try(Connection conn=ConnectionClass.getConn()){
            String query="select * from quanlydocgia ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                 if(rs.getString("UserName").equals(UserName))
                     KQ=1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return KQ;
    }

    
}
