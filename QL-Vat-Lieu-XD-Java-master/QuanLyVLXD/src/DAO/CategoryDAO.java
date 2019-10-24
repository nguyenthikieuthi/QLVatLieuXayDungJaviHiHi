/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Category;
import GUI.MainJForm;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class CategoryDAO {
    public static ArrayList<Category> GetAllCate(){
        Connection conn = ConnectionDatabase.getConnection();
        ArrayList<Category> arrCate = new ArrayList<>();
        try {
            CallableStatement callable = conn.prepareCall("{call SHOW_LoaiSanPham}");
            callable.execute();
            ResultSet rs = callable.getResultSet();
            while(rs.next()){
                Category cate = new Category(rs.getString(1),rs.getString(2));
                arrCate.add(cate);
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
    
    public static void AddCate(Category Cate){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_InsertLoaiSP(?,?)}");
            callable.setString(1, Cate.getMaloai());
            callable.setString(2, Cate.getTenLoai());
            callable.executeUpdate();
            
        } catch (SQLException ex) {
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    public static void DeleteCate(String Cate_ID){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_DeleteLoaiSP(?)}");
            callable.setString(1, Cate_ID);
            callable.executeUpdate();
            
        } catch (SQLException ex) {
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    public static void UpdateCategory(Category cate){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_UpdateLoaiSP(?,?)}");
            callable.setString(1, cate.getMaloai());
            callable.setString(2, cate.getTenLoai());
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
