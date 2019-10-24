/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.SanPhamDAL;
import DTO.Products;
import java.util.ArrayList;

/**
 *
 * @author thaotruogg
 */
public class SanPhamDLL {
    SanPhamDAL dal = new SanPhamDAL();
    
    public ArrayList<Products> getAllProducts(){
        return dal.getAllProducts();
    }
    
    public ArrayList<Products> getById(String id){
        return dal.getById(id);
    }
     public static void AddProduct(Products prod){
        SanPhamDAL.AddProduct(prod);
    }
    public static void DeleteProduct(String pro_id){
        SanPhamDAL.DeleteProduct(pro_id);
    }
    public static void UpdateProduct(Products prod){
        SanPhamDAL.UpdateProduct(prod);
    }
}
