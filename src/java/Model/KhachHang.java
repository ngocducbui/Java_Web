/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {

    private String maKhachHang;
    private String tenDangNhap;
    private String matKhau;
    private String hoVaTen;
    private String gioiTInh;
    private String diaChi;
    private String diaChiNhanHang;
    private String diaChiMuaHang;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private Boolean dangKyNhanBanTin;

    public KhachHang() {
    }
//m                        aKhacHang, tenDangNhap,         matKhau,           hoVaTen,         gioiTinh, d       iaChi, diaChi         NhanHang, d  iaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);

    public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTInh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, Boolean dangKyNhanBanTin) {
        this.maKhachHang = maKhachHang;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoVaTen = hoVaTen;
        this.gioiTInh = gioiTInh;
        this.diaChi = diaChi;
        this.diaChiNhanHang = diaChiNhanHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.dangKyNhanBanTin = dangKyNhanBanTin;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTInh() {
        return gioiTInh;
    }

    public void setGioiTInh(String gioiTInh) {
        this.gioiTInh = gioiTInh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isDangKyNhanBangTin() {
        return this.dangKyNhanBanTin;
    }

    public void setDangKyNhanBanTin(Boolean dangKyNhanBanTin) {
        this.dangKyNhanBanTin = dangKyNhanBanTin;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

}
