/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.util.ArrayList;
import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO implements DAOInterface<KhachHang> {

    public ArrayList<KhachHang> data = new ArrayList();

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList ketQua = new ArrayList();

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
                KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
                ketQua.add(kh);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException var19) {
            var19.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public KhachHang selectById(KhachHang t
    ) {
        KhachHang ketQua = null;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
            System.out.println(sql);

            String maKhacHang;
            String tenDangNhap;
            String matKhau;
            String hoVaTen;
            String gioiTinh;
            String diaChi;
            String diaChiNhanHang;
            String diaChiMuaHang;
            Date ngaySinh;
            String soDienThoai;
            String email;
            boolean dangKyNhanBangTin;
            for (ResultSet rs = st.executeQuery(); rs.next(); ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin)) {
                maKhacHang = rs.getString("makhachhang");
                tenDangNhap = rs.getString("tendangnhap");
                matKhau = rs.getString("matkhau");
                hoVaTen = rs.getString("hoten");
                gioiTinh = rs.getString("gioitinh");
                diaChi = rs.getString("diachi");
                diaChiNhanHang = rs.getString("diachinhanhang");
                diaChiMuaHang = rs.getString("diachimuahang");
                ngaySinh = rs.getDate("ngaysinh");
                soDienThoai = rs.getString("sodienthoai");
                email = rs.getString("email");
                dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException var19) {
            var19.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(KhachHang t
    ) {
        int ketQua = 0;
        try {
            final Connection con = JDBCUtil.getConnection();
            final String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkinhanbangtin)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
            st.setString(2, t.getTenDangNhap());
            st.setString(3, t.getMatKhau());
            st.setString(4, t.getHoVaTen());
            st.setString(5, t.getGioiTInh());
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getDiaChiNhanHang());
            st.setString(8, t.getDiaChiMuaHang());
            java.util.Date utilDate = new java.util.Date();
            utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(9, sqlDate);
            st.setString(10, t.getSoDienThoai());
            st.setString(11, t.getEmail());
            st.setBoolean(12, t.isDangKyNhanBangTin());
            ketQua = st.executeUpdate();
            System.out.println("B\u1ea1n \u0111\u00e3 th\u1ef1c thi: " + sql);
            System.out.println("C\u00f3 " + ketQua + " d\u00f2ng b\u1ecb thay \u0111\u1ed5i!");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

//    public static void main(String[] args) {
//        try {
//            long miliSeconds = System.currentTimeMillis();
//
//            Date date2 = new Date(miliSeconds);
//            //String                     maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTInh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, Boolean dangKyNhanBanTin) {
//           // KhachHang gg = new KhachHang("KH374d7", "ngoc", "duc", "nam", "ha", "ha", "ha", "ha", date2, "222", "d", dangKyNhanBangTin!=null);
//            KhachHangDAO dao = new KhachHangDAO();
//            dao.insert(gg);
//        } catch (Exception e) {
//
//            System.out.println("sai");
//        }
//    }
    public int insertAll(final ArrayList<KhachHang> arr) {
        int dem = 0;
        for (final KhachHang KhachHang : arr) {
            dem += this.insert(KhachHang);
        }
        return dem;
    }

    //  @Override
//    public int insertAll(ArrayList<KhachHang> arr
//    ) {
//        int dem = 0;
//
//        KhachHang KhachHang;
//        for (Iterator var4 = arr.iterator(); var4.hasNext(); dem += this.insert(KhachHang)) {
//            KhachHang = (KhachHang) var4.next();
//        }
//
//        return dem;
//    }
    @Override
    public int delete(KhachHang t
    ) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE from khachhang  WHERE makhachhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
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
    public int deleteAll(ArrayList<KhachHang> arr
    ) {
        int dem = 0;

        KhachHang KhachHang;
        for (Iterator var4 = arr.iterator(); var4.hasNext(); dem += this.delete(KhachHang)) {
            KhachHang = (KhachHang) var4.next();
        }

        return dem;
    }

    @Override
    public int update(KhachHang t
    ) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE khachhang  SET  tendangnhap=?, matkhau=?, hoten=?, gioitinh=?, diachi=?, diachinhanhang=?, diachimuahang=?, ngaysinh=?, sodienthoai=?, email=?, dangkinhanbangtin=? WHERE makhachhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenDangNhap());
            st.setString(2, t.getMatKhau());
            st.setString(3, t.getHoVaTen());
            st.setString(4, t.getGioiTInh());
            st.setString(5, t.getDiaChi());
            st.setString(6, t.getDiaChiNhanHang());
            st.setString(7, t.getDiaChiMuaHang());
            java.util.Date utilDate = new java.util.Date();
            utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(8, sqlDate);
            st.setString(9, t.getSoDienThoai());
            st.setString(10, t.getEmail());
            st.setBoolean(11, t.isDangKyNhanBangTin());
            st.setString(12, t.getMaKhachHang());
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

    public boolean kiemTraTenDangNhap(String tenDangNhap) {
        boolean ketQua = false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE tenDangNhap=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenDangNhap);
            ResultSet rs = st.executeQuery();
//            for (ResultSet rs = st.executeQuery(); rs.next(); ketQua = true) {
//            }
            while (rs.next()) {
                return true;
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return ketQua;
    }

    public KhachHang selectByUserNameAndPassword(String userName, String password
    ) {
        KhachHang ketQua = null;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE tendangnhap=? AND matkhau=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
                ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
            }
            JDBCUtil.closeConnection(con);

        } catch (SQLException var19) {
            var19.printStackTrace();
        }

        return ketQua;
    }
//    private ArrayList<KhachHang> data = new ArrayList<>();
//
//    @Override
//    public ArrayList<KhachHang> selectAll() {
//        return this.data;
//    }
//
//    @Override
//    public KhachHang selectById(KhachHang t) {
//        for (KhachHang KhachHang : data) {
//            if (data.equals(t)) {
//                return KhachHang;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int insert(KhachHang t) {
//        if (this.selectById(t) == null) {
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int insertAll(ArrayList<KhachHang> arr) {
//        int dem = 0;
//        for (KhachHang KhachHang : arr) {
//            dem += this.insert(KhachHang);
//        }
//        return dem;
//    }
//
//    @Override
//    public int delete(KhachHang t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteAll(ArrayList<KhachHang> arr) {
//        int dem = 0;
//        for (KhachHang KhachHang : arr) {
//            dem += this.delete(KhachHang);
//        }
//        return dem;
//    }
//
//    @Override
//    public int update(KhachHang t) {
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
//    }
}
