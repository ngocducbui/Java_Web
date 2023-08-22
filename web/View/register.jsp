<%-- 
    Document   : register.jsp
    Created on : Aug 17, 2023, 2:53:28 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>

        <%
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        %>

        <link  type="text/css" rel="stylesheet" href="<%=url%>/CSS/style.css">


    </head>
    <body>
        <%@include file="header.jsp" %>
        <%
            String baoLoi = (request.getAttribute("baoLoi") + "");
            baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

            String tenDangNhap = request.getAttribute("tenDangNhap") + "";
            tenDangNhap = (tenDangNhap.equals("null")) ? "" : tenDangNhap;

            String hoVaTen = request.getAttribute("hoVaTen") + "";
            hoVaTen = (hoVaTen.equals("null")) ? "" : hoVaTen;

            String gioiTinh = request.getAttribute("gioiTinh") + "";
            gioiTinh = (gioiTinh.equals("null")) ? "" : gioiTinh;

            String ngaySinh = request.getAttribute("ngaySinh") + "";
            ngaySinh = (ngaySinh.equals("null")) ? "" : ngaySinh;

            String diaChiKhachHang = request.getAttribute("diaChiKhachHang") + "";
            diaChiKhachHang = (diaChiKhachHang.equals("null")) ? "" : diaChiKhachHang;

            String diaChiMuaHang = request.getAttribute("diaChiMuaHang") + "";
            diaChiMuaHang = (diaChiMuaHang.equals("null")) ? "" : diaChiMuaHang;

            String diaChiNhanHang = request.getAttribute("diaChiNhanHang") + "";
            diaChiNhanHang = (diaChiNhanHang.equals("null")) ? "" : diaChiNhanHang;

            String dienThoai = request.getAttribute("dienThoai") + "";
            dienThoai = (dienThoai.equals("null")) ? "" : dienThoai;

            String email = request.getAttribute("email") + "";
            email = (email.equals("null")) ? "" : email;

            String dongYNhanMail = request.getAttribute("dongYNhanMail") + "";
            dongYNhanMail = (dongYNhanMail.equals("null")) ? "" : dongYNhanMail;

        %>

        <div class="container">
            <h1 class="text-center mb-4" style="color:blue; font-family: sans-serif; font-weight: bold">Đăng Ký</h1>
            <div class="red-star" style="color:red" id="baoloi">
                <%=baoLoi%>
            </div>
            <form class="form" action="/TestWeb/register" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <h3>Tài Khoản</h3>
                        <div class="mb-3">
                            <label for="tendangnhap" class="form-label">Tên Đăng Nhập <span class="red-star">*</span></label>
                            <input type="text" class="form-control" id="tendangnhap" name="tendangnhap" required="required" value="<%=tenDangNhap%>">
                        </div>
                        <div class="mb-3">
                            <label for="matkhau" class="form-label">Mật Khẩu <span class="red-star">*</span></label>
                            <input type="password" class="form-control" id="matkhau" name="matkhau" required="required" onkeyup="dongYDieuKhoan()">
                        </div>
                        <div class="mb-3">
                            <label for="matkhaunhaplai" class="form-label">Nhập Lại Mật Khẩu <span class="red-star">*</span><span class="red-star" id="msg"></span></label>
                            <input type="password" class="form-control" id="matkhaunhaplai" name="matkhaunhaplai" required="required" onkeyup="dongYDieuKhoan()">
                        </div>
                        <br>
                        <h3>Thông Tin Khách Hàng</h3>
                        <div class="mb-3">
                            <label for="hovaten" class="form-label">Họ Và Tên</label>
                            <input type="text" class="form-control" id="hovaten" name="hovaten" aria-describedby="emailHelp" value="<%=hoVaTen%>">
                        </div>
                        <div class="mb-3">
                            <label for="gioitinh" class="form-label">Giới Tính</label>
                            <select class="form-control" id="gioitinh" name="gioitinh">
                                <option></option>
                                <option value="Nam" <%= (gioiTinh.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
                                <option value="Nữ" <%= (gioiTinh.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
                                <option value="Khác"<%= (gioiTinh.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="ngaysinh" class="form-label">Ngày Sinh</label>
                            <input type="date" class="form-control" id="ngaysinh" name="ngaysinh" value="<%=ngaySinh%>">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h3>Địa Chỉ</h3>
                        <div class="mb-3">
                            <label for="diachikhachhang" class="form-label">Địa Chỉ Khách Hàng</label>
                            <input type="text" class="form-control" id="diachikhachhang" name="diachikhachhang" value="<%=diaChiKhachHang%>">
                        </div>
                        <div class="mb-3">
                            <label for="diachimuahang" class="form-label">Địa Chỉ Mua Hàng</label>
                            <input type="text" class="form-control" id="diachimuahang" name="diachimuahang" value="<%=diaChiMuaHang%>">
                        </div>
                        <div class="mb-3">
                            <label for="diachinhanhang" class="form-label">Địa Chỉ Nhận Hàng</label>
                            <input type="text" class="form-control" id="diachinhanhang" name="diachinhanhang" value="<%=diaChiNhanHang%>">
                        </div>
                        <div class="mb-3">
                            <label for="dienthoai" class="form-label">Điện Thoại</label>
                            <input type="tel" class="form-control" id="dienthoai" name="dienthoai" value="<%=dienThoai%>">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%=email%>">
                        </div>
                        <div class="mb-3">
                            <input type="checkbox" class="form-check-input" id="dongy" name="dongy" required="required" onchange="dongYDieuKhoan()">
                            <label for="dongy" class="form-label" >Đồng ý với các điều khoản của công ty<span class="red-star">*</span></label>
                        </div>

                        <div class="mb-3">
                            <input type="checkbox" class="form-check-input" id="dongynhanemail" name="dongynhanemail"  > 
                            <label for="dongynhanemail" class="form-label">Đồng ý nhận email</label>
                        </div>
                        <!--                <div class="mb-3 form-check">
                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                            <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                        </div>-->
                        <button type="submit " class="btn btn-primary form-control dsisableds" name="submit" id="submit" 
                                onClick="changeButton()" style="pointer-events: none;   background-color: #ccc;" >Đăng Ký</button>
                    </div>
                </div>
            </form>
        </div>
        <!--        <button id="hi" onmouseover="changeButton()" value="hâhahah">aaa</button>-->
        <script src="../JS/app.js" ></script>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    <script>
//                                    function kiemTraMatKhau() {
//                                        matkhau = document.getElementById("matkhau").value;
//                                        matkhau2 = document.getElementById("matkhaunhaplai").value;
//                                        if (matkhau != matkhau2) {
//                                            matkhau2 = document.getElementById("msg").innerHTML = "Mật khẩu không khớp";
//                                            return false;
//                                        } else {
//                                            matkhau2 = document.getElementById("msg").innerHTML = "";
//                                            return true;
//                                        }
//                                    }
                                    function dongYDieuKhoan() {
                                        matkhau = document.getElementById("matkhau").value;
                                        matkhau2 = document.getElementById("matkhaunhaplai").value;
                                        dongy = document.getElementById("dongy");

                                        if (dongy.checked == true && matkhau == matkhau2 && matkhau != "") {
                                            document.getElementById("submit").style.pointerEvents = "auto";
                                            document.getElementById("submit").style.backgroundColor = "#0d6efd";
                                        } else {
                                            document.getElementById("submit").style.pointerEvents = "none";
                                            document.getElementById("submit").style.backgroundColor = "#ccc";
                                        }
                                        if (matkhau != matkhau2) {
                                            matkhau2 = document.getElementById("msg").innerHTML = "Mật khẩu không khớp";
                                        } else {
                                            matkhau2 = document.getElementById("msg").innerHTML = "";
                                        }

                                    }
    </script>
</html>

<!--pointer-events: none;-->
