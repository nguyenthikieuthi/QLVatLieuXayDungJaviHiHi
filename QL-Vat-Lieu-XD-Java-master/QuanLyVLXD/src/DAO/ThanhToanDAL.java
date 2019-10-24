/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Pay;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ThanhToanDAL {
    public static ArrayList<Pay> GetAllPay(){
        Connection conn = ConnectionDatabase.getConnection();
        ArrayList<Pay> arrCate = new ArrayList<>();
        try {
            CallableStatement callable = conn.prepareCall("{call SHOW_ThanhToan}");
            callable.execute();
            ResultSet rs = callable.getResultSet();
            while(rs.next()){
                Pay pay = new Pay(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
                arrCate.add(pay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arrCate;
    }
    
    public static void AddPay(Pay pay){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_InsertThanhToan(?,?,?,?)}");
            callable.setString(1, pay.getSoPhieu());
            callable.setString(2, pay.getNgayPhieu());
            callable.setFloat(3, pay.getSoTien());
            callable.setString(4, pay.getMaKH());
            callable.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToanDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    public static void DeletePay(String maPhieu){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_DeleteLoaiSP(?)}");
            callable.setString(1, maPhieu);
            callable.executeUpdate();
            
        } catch (SQLException ex) {
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    public static void UpdatePay(Pay pay){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_UpdateThanhToan(?,?,?,?)}");
            callable.setString(1, pay.getSoPhieu());
            callable.setString(2, pay.getNgayPhieu());
            callable.setFloat(3, pay.getSoTien());
            callable.setString(4, pay.getMaKH());
            callable.executeUpdate();
        } catch (SQLException ex) {
        }finally{   
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
}
