/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.CategoryDAO;
import DTO.Category;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CategoryDLL {
    
    public static ArrayList<Category> GetAllCate(){
        ArrayList<Category> arrCate = CategoryDAO.GetAllCate();
        return arrCate;
    }
    public static void AddCategory(Category Cate){
        CategoryDAO.AddCate(Cate);
    }
    public static void DeleteCategory(String Cate_ID){
        CategoryDAO.DeleteCate(Cate_ID);
    }
    public static void UpdateCategory(Category cate){
        CategoryDAO.UpdateCategory(cate);
    }
}
