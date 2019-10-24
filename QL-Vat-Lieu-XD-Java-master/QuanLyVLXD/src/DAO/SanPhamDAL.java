/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Products;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaotruogg
 */
public class SanPhamDAL extends ConnectionData{
    private final String QUERY_PRODUCTS = "EXEC dbo.SHOW_SanPham";
    private final String GET_BY_ID = "SELECT * FROM dbo.SANPHAM WHERE maSanPham=?";
    
    public ArrayList<Products> getAllProducts(){
        Connection conn = ConnectionDatabase.getConnection();
        ArrayList<Products> ProdArr = new ArrayList<>();
        try {
            CallableStatement callable = conn.prepareCall("{call Show_SanPham}");
            callable.execute();
            ResultSet rs = callable.getResultSet();
            while(rs.next()){
                Products pro = new Products(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                ProdArr.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ProdArr;
    }
    
    public ArrayList<Products> getById(String id){
        ArrayList<Products> obj = new ArrayList<>();
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                Products item = new Products();
                item.setMaSP(rs.getString("maSanPham"));
                item.setTenSP(rs.getString("tenSanPham"));
                obj.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
     public static void AddProduct(Products prod){
        Connection conn = ConnectionDatabase.getConnection();
        try {
//            Connection conn = ConnectionDatabase.getConnection();
            CallableStatement callable = conn.prepareCall("{call USP_InsertSanPham(?,?,?,?)}");
            callable.setString(1, prod.getMaSP());
            callable.setString(2, prod.getTenSP());
            callable.setString(3, prod.getNhaSX());
            callable.setString(4, prod.getMaLoai());
            callable.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void DeleteProduct(String prod_id){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_DeleteSanPham(?)}");
            callable.setString(1, prod_id);
            callable.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void UpdateProduct(Products prod){
        Connection conn = ConnectionDatabase.getConnection();
        try {
            CallableStatement callable = conn.prepareCall("{call USP_UpdateSanPham(?,?,?,?)}");
            callable.setString(1, prod.getMaSP());
            callable.setString(2, prod.getTenSP());
            callable.setString(3, prod.getNhaSX());
            callable.setString(4, prod.getMaLoai());
            callable.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
