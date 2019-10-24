/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class Pay {
   private String soPhieu, ngayPhieu, MaKH;
   private float SoTien;

    public Pay(String soPhieu, String ngayPhieu, float SoTien, String MaKH) {
        this.soPhieu = soPhieu;
        this.ngayPhieu = ngayPhieu;
        this.SoTien = SoTien;
        this.MaKH = MaKH;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgayPhieu() {
        return ngayPhieu;
    }

    public void setNgayPhieu(String ngayPhieu) {
        this.ngayPhieu = ngayPhieu;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public float getSoTien() {
        return SoTien;
    }

    public void setSoTien(float SoTien) {
        this.SoTien = SoTien;
    }
    
   
}
