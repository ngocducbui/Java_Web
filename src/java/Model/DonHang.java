/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Objects;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DonHang {

    private String maDonHang;
    private KhachHang khachHang;
    private String diaChiMuaHang;
    private String diaChiNhanHang;
    private String maKhachHang;
    private String trangThai;
    private String hinhThucThanhToan;
    private String trangThaiThanhToan;
    private double soTienDaThanhToan;
    private double soTienConThieu;
    private Date ngayDatHang;
    private Date ngayNhanHang;

    public DonHang() {
    }

    public DonHang(String maDonHnag, KhachHang khachHang, String diaChiMuaHang, String diaChiNhanHang, String maKhachHang, String trangThai, String hinhThucThanhToan, String trangThaiThanhToan, double soTienDaThanhToan, double soTienConThieu, Date ngayDatHang, Date ngayNhanHang) {
        this.maDonHang = maDonHnag;
        this.khachHang = khachHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.diaChiNhanHang = diaChiNhanHang;
        this.maKhachHang = maKhachHang;
        this.trangThai = trangThai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.soTienDaThanhToan = soTienDaThanhToan;
        this.soTienConThieu = soTienConThieu;
        this.ngayDatHang = ngayDatHang;
        this.ngayNhanHang = ngayNhanHang;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHnag) {
        this.maDonHang = maDonHnag;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public double getSoTienDaThanhToan() {
        return soTienDaThanhToan;
    }

    public void setSoTienDaThanhToan(double soTienDaThanhToan) {
        this.soTienDaThanhToan = soTienDaThanhToan;
    }

    public double getSoTienConThieu() {
        return soTienConThieu;
    }

    public void setSoTienConThieu(double soTienConThieu) {
        this.soTienConThieu = soTienConThieu;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Date getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(Date ngayNhanHang) {
        this.ngayNhanHang = ngayNhanHang;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DonHang other = (DonHang) obj;
        return Objects.equals(maDonHang, other.maDonHang);
    }

}
