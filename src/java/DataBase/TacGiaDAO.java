/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.util.ArrayList;
import Model.TacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class TacGiaDAO implements DAOInterface<TacGia> {

    @Override
    public ArrayList<TacGia> selectAll() {
        final ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM tacgia";
            final PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final String maTacGia = rs.getString("matacgia");
                final String hoVaTen = rs.getString("hovaten");
                final Date ngaySinh = rs.getDate("ngaysinh");
                final String tieuSu = rs.getString("tieusu");
                final TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                ketQua.add(tg);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public TacGia selectByIdReal(String t) {
        TacGia ketQua = null;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM tacgia WHERE matacgia=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t);
            //System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final String maTacGia = rs.getString("matacgia");
                final String hoVaTen = rs.getString("hovaten");
                final Date ngaySinh = rs.getDate("ngaysinh");
                final String tieuSu = rs.getString("tieusu");
                final TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);

            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(TacGia t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu)  VALUES (?,?,?,?)";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            st.setString(2, t.getHoVaTen());
            java.util.Date utilDate = new java.util.Date();
            utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(3, sqlDate);
            st.setString(4, t.getTieuSu());
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
    public int insertAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (final TacGia tacGia : arr) {
            dem += this.insert(tacGia);
        }
        return dem;
    }

    @Override
    public int delete(TacGia t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "DELETE from tacgia  WHERE matacgia=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
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
    public int deleteAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (final TacGia tacGia : arr) {
            dem += this.delete(tacGia);
        }
        return dem;
    }

    @Override
    public int update(TacGia t) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "UPDATE tacgia  SET  hovaten=?, ngaysinh=?, tieusu=? WHERE matacgia=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getHoVaTen());
            java.util.Date utilDate = new java.util.Date();
            utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            st.setDate(2, sqlDate);
            st.setString(3, t.getTieuSu());
            st.setString(4, t.getMaTacGia());
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
    public TacGia selectById(TacGia t) {
        TacGia ketQua = null;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "SELECT * FROM tacgia WHERE matacgia=?";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            System.out.println(sql);
            final ResultSet rs = st.executeQuery();
            if (rs.next()) {
                final String maTacGia = rs.getString("matacgia");
                final String hoVaTen = rs.getString("hovaten");
                final Date ngaySinh = rs.getDate("ngaysinh");
                final String tieuSu = rs.getString("tieusu");
                ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static void main(String[] args) {
        TacGiaDAO dao = new TacGiaDAO();
        ArrayList<TacGia> list = new ArrayList<TacGia>();
        // list = dao.selectAll();
        TacGia ttt = new TacGia();
        ttt = dao.selectByIdReal("TG1");
        System.out.println(ttt.toString());
//        for (TacGia tacGia : list) {
//            System.out.println(tacGia.toString());
//        }
        // System.out.println(list.size());
        // dao.insert(new TacGia("TG8","duc",new java.util.Date(2022-1900,01,02),"hi"));
    }
}
