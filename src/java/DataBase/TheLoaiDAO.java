/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.util.ArrayList;

import Model.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class TheLoaiDAO implements DAOInterface<TheLoai> {

    private ArrayList<TheLoai> data;

    public TheLoaiDAO() {
        this.data = new ArrayList<TheLoai>();
    }

    @Override
    public ArrayList<TheLoai> selectAll() {
        final ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM theloai";
            final PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final String maTheLoai = rs.getString("matheloai");
                final String tenTheLoai = rs.getString("tentheloai");
                final TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
                ketQua.add(tl);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public TheLoai selectById(TheLoai t) {
        TheLoai ketQua = null;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM theloai WHERE matheloai=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());
            System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            if (rs.next()) {
                final String maTheLoai = rs.getString("matheloai");
                final String tenTheLoai = rs.getString("tentheloai");
                ketQua = new TheLoai(maTheLoai, tenTheLoai);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(TheLoai t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "INSERT INTO theloai (matheloai, tentheloai)  VALUES (?,?)";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());
            st.setString(2, t.getTenTheLoai());
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
    public int insertAll(ArrayList<TheLoai> arr) {
        int dem = 0;
        for (final TheLoai theLoai : arr) {
            dem += this.insert(theLoai);
        }
        return dem;
    }

    @Override
    public int delete(TheLoai t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "DELETE from theloai  WHERE matheloai=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());
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
    public int deleteAll(ArrayList<TheLoai> arr) {
        int dem = 0;
        for (final TheLoai TheLoai : arr) {
            dem += this.delete(TheLoai);
        }
        return dem;
    }

    @Override
    public int update(TheLoai t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "UPDATE theloai  SET  tenTheLoai=? WHERE matheloai=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenTheLoai());
            st.setString(2, t.getMaTheLoai());
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

//    private ArrayList<TheLoai> data = new ArrayList<>();
//
//    @Override
//    public ArrayList<TheLoai> selectAll() {
//        return this.data;
//    }
//
//    @Override
//    public TheLoai selectById(TheLoai t) {
//        for (TheLoai TheLoai : data) {
//            if (data.equals(t)) {
//                return TheLoai;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int insert(TheLoai t) {
//        if (this.selectById(t) == null) {
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int insertAll(ArrayList<TheLoai> arr) {
//        int dem = 0;
//        for (TheLoai TheLoai : arr) {
//            dem += this.insert(TheLoai);
//        }
//        return dem;
//    }
//
//    @Override
//    public int delete(TheLoai t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteAll(ArrayList<TheLoai> arr) {
//        int dem = 0;
//        for (TheLoai TheLoai : arr) {
//            dem += this.delete(TheLoai);
//        }
//        return dem;
//    }
//
//    @Override
//    public int update(TheLoai t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
}
