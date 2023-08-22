/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import Model.Cart;
import java.util.ArrayList;

import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.TacGia;
import Model.TheLoai;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO implements DAOInterface<SanPham> {

    @Override
    public ArrayList<SanPham> selectAll() {
        final ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM sanpham";
            final PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final String masanpham = rs.getString("masanpham");
                final String tensanpham = rs.getString("tensanpham");
                final String matacgia = rs.getString("matacgia");
                final int namxuatban = rs.getInt("namxuatban");
                final double gianhap = rs.getDouble("gianhap");
                final double giagoc = rs.getDouble("giagoc");
                final double giaban = rs.getDouble("giaban");
                final int soluong = (int) rs.getDouble("soluong");
                final String matheloai = rs.getString("matheloai");
                final String ngonngu = rs.getString("ngonngu");
                final String mota = rs.getString("mota");
                final TacGia tacGia = new TacGiaDAO().selectById(new TacGia(matacgia, "", (Date) null, ""));
                final TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(matheloai, ""));
                final SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong, theLoai, ngonngu, mota);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public List<Cart> getCartProduct(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<Cart>();
        try {
            if (cartList.size() > 0) {
                final Connection con = JDBCUtil.getConnection();

                for (Cart item : cartList) {
                    String query = "select *from sanpham where masanpham=?";
                    final PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, item.getMaSanPham());
                    final ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setMaSanPham(rs.getString("masanpham"));
                        row.setTenSanPham(rs.getString("tensanpham"));
                        final String matacgia = rs.getString("matacgia");
                        final TacGia tacGia = new TacGiaDAO().selectById(new TacGia(matacgia, "", (Date) null, ""));
                        row.setTacGia(tacGia);
                        row.setNamXuatBan(rs.getInt("namxuatban"));
                        row.setGiaNhap(rs.getInt("gianhap"));
                        row.setGiaGoc(rs.getInt("giagoc"));
                        row.setGiaBan(rs.getInt("giaban") * item.getQuantity());
                        row.setSoLuong((int) rs.getDouble("soluong"));
                        final String matheloai = rs.getString("matheloai");
                        final TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(matheloai, ""));
                        row.setTheLoai(theLoai);
                        row.setNgonNgu(rs.getString("ngonngu"));
                        row.setMoTa(rs.getString("mota"));
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public SanPham selectById(SanPham t) {
        SanPham ketQua = null;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM sanpham WHERE masanpham=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            final ResultSet rs = st.executeQuery();
            if (rs.next()) {
                final String masanpham = rs.getString("masanpham");
                final String tensanpham = rs.getString("tensanpham");
                final String matacgia = rs.getString("matacgia");
                final int namxuatban = rs.getInt("namxuatban");
                final double gianhap = rs.getDouble("gianhap");
                final double giagoc = rs.getDouble("giagoc");
                final double giaban = rs.getDouble("giaban");
                final int soluong = (int) rs.getDouble("soluong");
                final String matheloai = rs.getString("matheloai");
                final String ngonngu = rs.getString("ngonngu");
                final String mota = rs.getString("mota");
                final TacGia tacGia = new TacGiaDAO().selectById(new TacGia(matacgia, "", (Date) null, ""));
                final TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(matheloai, ""));
                ketQua = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong, theLoai, ngonngu, mota);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(SanPham t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban, gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota)  VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            st.setString(2, t.getTenSanPham());
            st.setString(3, t.getTacGia().getMaTacGia());
            st.setInt(4, t.getNamXuatBan());
            st.setDouble(5, t.getGiaNhap());
            st.setDouble(6, t.getGiaGoc());
            st.setDouble(7, t.getGiaBan());
            st.setInt(8, t.getSoLuong());
            st.setString(9, t.getTheLoai().getMaTheLoai());
            st.setString(10, t.getNgonNgu());
            st.setString(11, t.getMoTa());
            ketQua = st.executeUpdate();
            System.out.println("B\u1ea1n \u0111\u00e3 th\u1ef1c thi: " + sql);
            System.out.println("C\u00f3 " + ketQua + " d\u00f2ng b\u1ecb thay \u0111\u1ed5i!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (final SanPham SanPham : arr) {
            dem += this.insert(SanPham);
        }
        return dem;
    }

    @Override
    public int delete(SanPham t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "DELETE from sanpham  WHERE masanpham=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            System.out.println(sql);
            ketQua = st.executeUpdate();
            System.out.println("B\u1ea1n \u0111\u00e3 th\u1ef1c thi: " + sql);
            System.out.println("C\u00f3 " + ketQua + " d\u00f2ng b\u1ecb thay \u0111\u1ed5i!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (final SanPham SanPham : arr) {
            dem += this.delete(SanPham);
        }
        return dem;
    }

    @Override
    public int update(SanPham t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "UPDATE sanpham  SET tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=? WHERE masanpham=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenSanPham());
            st.setString(2, t.getTacGia().getMaTacGia());
            st.setInt(3, t.getNamXuatBan());
            st.setDouble(4, t.getGiaNhap());
            st.setDouble(5, t.getGiaGoc());
            st.setDouble(6, t.getGiaBan());
            st.setInt(7, t.getSoLuong());
            st.setString(8, t.getTheLoai().getMaTheLoai());
            st.setString(9, t.getNgonNgu());
            st.setString(10, t.getMoTa());
            st.setString(11, t.getMaSanPham());
            System.out.println(sql);
            ketQua = st.executeUpdate();
            System.out.println("B\u1ea1n \u0111\u00e3 th\u1ef1c thi: " + sql);
            System.out.println("C\u00f3 " + ketQua + " d\u00f2ng b\u1ecb thay \u0111\u1ed5i!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

//    private ArrayList<SanPham> data = new ArrayList<>();
//
//    @Override
//    public ArrayList<SanPham> selectAll() {
//        return this.data;
//    }
//
//    @Override
//    public SanPham selectById(SanPham t) {
//        for (SanPham SanPham : data) {
//            if (data.equals(t)) {
//                return SanPham;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int insert(SanPham t) {
//        if (this.selectById(t) == null) {
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int insertAll(ArrayList<SanPham> arr) {
//        int dem = 0;
//        for (SanPham SanPham : arr) {
//            dem += this.insert(SanPham);
//        }
//        return dem;
//    }
//
//    @Override
//    public int delete(SanPham t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteAll(ArrayList<SanPham> arr) {
//        int dem = 0;
//        for (SanPham SanPham : arr) {
//            dem += this.delete(SanPham);
//        }
//        return dem;
//    }
//
//    @Override
//    public int update(SanPham t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
}
