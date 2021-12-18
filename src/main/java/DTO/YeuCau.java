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
public class YeuCau {
    private String MaSach;
    private String UserName;

    public YeuCau(String UserName, String MaSach) {
        this.MaSach = MaSach;
        this.UserName = UserName;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getUserName() {
        return UserName;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
}
