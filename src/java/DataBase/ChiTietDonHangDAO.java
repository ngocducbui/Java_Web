/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.util.ArrayList;

import Model.ChiTietDonHang;
import Model.DonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * F
 *
 * @author ADMIN
 */
public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

    @Override
    public ArrayList<ChiTietDonHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietDonHang selectById(ChiTietDonHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(ChiTietDonHang t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitietdonhang (machitietdonhang, donhang,sanpham, soluong, giagoc,giamgia,giaban,thuevat,tongtien)  VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());
            st.setString(2, t.getDonHang().getMaDonHang());
            st.setString(3, t.getSanPham().getMaSanPham());
            st.setDouble(4, t.getSoLuong());
            st.setDouble(5, t.getGiaGoc());
            st.setDouble(7, t.getGiamGia());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(8, t.getThueVAT());
            st.setDouble(9, t.getTongTien());
            ketQua = st.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;

        ChiTietDonHang ChiTietDonHang;
        for (Iterator var4 = arr.iterator(); var4.hasNext(); dem += this.insert(ChiTietDonHang)) {
            ChiTietDonHang = (ChiTietDonHang) var4.next();
        }

        return dem;
    }

    @Override
    public int delete(ChiTietDonHang t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE from chitietdonhang  WHERE machitietdonhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());
            System.out.println(sql);
            ketQua = st.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;

        ChiTietDonHang ChiTietDonHang;
        for (Iterator var4 = arr.iterator(); var4.hasNext(); dem += this.delete(ChiTietDonHang)) {
            ChiTietDonHang = (ChiTietDonHang) var4.next();
        }

        return dem;
    }

    @Override
    public int update(ChiTietDonHang t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitietdonhang SET donhang=?, sanpham=?, soluong=?, giagoc=?, giamgia=?, giaban=?, thuevat=?, tongtien=? WHERE machitietdonhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getDonHang().getMaDonHang());
            st.setString(2, t.getSanPham().getMaSanPham());
            st.setDouble(3, t.getSoLuong());
            st.setDouble(4, t.getGiaGoc());
            st.setDouble(5, t.getGiamGia());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(7, t.getThueVAT());
            st.setDouble(8, t.getTongTien());
            st.setString(9, t.getMaChiTietDonHang());
            System.out.println(sql);
            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return ketQua;
    }

}
