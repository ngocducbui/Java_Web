/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.util.ArrayList;

import Model.DonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author ADMIN
 */
public class DonHangDAO implements DAOInterface<DonHang> {

    @Override
    public ArrayList<DonHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DonHang selectById(DonHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(DonHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertAll(ArrayList<DonHang> arr) {
        int kq = 0;
        DonHang donHang;
        for (Iterator var4 = arr.iterator(); var4.hasNext(); kq += this.insert(donHang)) {
            donHang = (DonHang) var4.next();
        }

        return kq;
    }

    @Override
    public int delete(DonHang t) {
        int kq = 0;
        Connection con = JDBCUtil.getConnection();
        String sql = "DELETE FROM donhang WHERE madonhang = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaDonHang());
            kq = st.executeUpdate();
            con.close();
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return kq;
    }

    @Override
    public int deleteAll(ArrayList<DonHang> arr) {
        int kq = 0;

        DonHang t;
        for (Iterator var4 = arr.iterator(); var4.hasNext(); kq += this.delete(t)) {
            t = (DonHang) var4.next();
        }

        return kq;
    }

    @Override
    public int update(DonHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
//    private ArrayList<DonHang> data = new ArrayList<>();
//
//    @Override
//    public ArrayList<DonHang> selectAll() {
//        return this.data;
//    }
//
//    @Override
//    public DonHang selectById(DonHang t) {
//        for (DonHang DonHang : data) {
//            if (data.equals(t)) {
//                return DonHang;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int insert(DonHang t) {
//        if (this.selectById(t) == null) {
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int insertAll(ArrayList<DonHang> arr) {
//        int dem = 0;
//        for (DonHang DonHang : arr) {
//            dem += this.insert(DonHang);
//        }
//        return dem;
//    }
//
//    @Override
//    public int delete(DonHang t) {
//        if (this.selectById(t) != null) {
//            ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
//            ctdh.deleteAll(t);
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteAll(ArrayList<DonHang> arr) {
//        int dem = 0;
//        for (DonHang DonHang : arr) {
//            dem += this.delete(DonHang);
//        }
//        return dem;
//    }
//
//    @Override
//    public int update(DonHang t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
//}
