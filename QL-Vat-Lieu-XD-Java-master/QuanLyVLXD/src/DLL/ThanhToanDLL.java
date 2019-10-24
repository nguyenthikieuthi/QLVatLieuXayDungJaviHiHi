/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.ThanhToanDAL;
import DTO.Pay;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ThanhToanDLL {
    public static ArrayList<Pay> GetAllPay(){
        ArrayList<Pay> arrPay = ThanhToanDAL.GetAllPay();
        return arrPay;
    }
    public static void AddPay(Pay pay){
        ThanhToanDAL.AddPay(pay);
    }
    public static void DeletePay(String pay_ID){
        ThanhToanDAL.DeletePay(pay_ID);
    }
    public static void UpdatePay(Pay pay){
        ThanhToanDAL.UpdatePay(pay);
    }
}
