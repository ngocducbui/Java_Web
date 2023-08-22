/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DataBase.KhachHangDAO;
import Model.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String tenDangNhap = request.getParameter("tendangnhap");
        String matKhau = request.getParameter("matkhau");
        String matKhauNhapLai = request.getParameter("matkhaunhaplai");
        String hoVaTen = request.getParameter("tendangnhap");
        String gioiTinh = request.getParameter("gioitinh");
        String ngaySinh = request.getParameter("ngaysinh");
        String diaChiKhachHang = request.getParameter("diachikhachhang");
        String diaChiMuaHang = request.getParameter("diachimuahang");
        String diaChiNhanHang = request.getParameter("diachinhanhang");
        String dienThoai = request.getParameter("dienthoai");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongynhanemail");

        request.setAttribute("tenDangNhap", tenDangNhap);
        request.setAttribute("hoVaTen", hoVaTen);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("ngaySinh", ngaySinh);
        request.setAttribute("diaChiKhachHang", diaChiKhachHang);
        request.setAttribute("diaChiMuaHang", diaChiMuaHang);
        request.setAttribute("diaChiNhanHang", diaChiNhanHang);
        request.setAttribute("dienThoai", dienThoai);
        request.setAttribute("email", email);
        request.setAttribute("dongYNhanMail", dongYNhanMail);

        String baoLoi = "";
        String url = "";
        KhachHangDAO dao = new KhachHangDAO();
        if (dao.kiemTraTenDangNhap(tenDangNhap)) {
            baoLoi += "Tên Đăng Nhập Đã Tồn Tại. Vui Lòng Thử Lại!";
        }
        if (!matKhau.equals(matKhauNhapLai)) {
            baoLoi += "Mật Khẩu Không Khớp. Vui Lòng Thử Lại!";
        }
        if (baoLoi.length() > 0) {
            url = "/View/register.jsp";
        } else {
            Random rd = new Random();
            String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = dateFormat.parse(ngaySinh);
            } catch (ParseException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }
//                public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTInh, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, Boolean dangKyNhanBanTin) {

            KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, date, dienThoai, email, dongYNhanMail != null);
            dao.insert(kh);

           // baoLoi += "thanhcong";
            request.setAttribute("success", true);

            url = "/View/index.jsp";
        }

        request.setAttribute("baoLoi", baoLoi);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
