<%@page import="Model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<nav class="navbar navbar-expand-lg bg-body-tertiary" >
    <div class="container-fluid" >
        <!--                <a class="navbar-brand" href="#">NGOC DUC</a>-->
        <a class="navbar-brand" href="#">
            <img src="<%=url%>/image/a.jpg" alt="Logo"  height="40" class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse col-md-4 justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=url%>/View/index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Combo Giảm Giá</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thể Loại
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Quần Jean</a></li>
                        <li><a class="dropdown-item" href="#">Áo Thun</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Áo Sơ Mi</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Hết Hàng</a>
                </li>
            </ul>
            <div class="col-md-4">
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Nội Dung Tìm Kiếm" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Tìm</button>


                </form>
            </div>
            <div class="  col-md-4 right">
                <a href="<%=url%>/View/card.jsp"">
                    <i class="fas fa-shopping-cart align-middle  " style="margin-right: 3%;  font-size: 25px; color:blue">
                        <p class="badge badge-secondary align-middle text-center px-1" style="color:red; background-color: #ff0000;color: #ffffff;font-size: 13px;  margin:auto">
                            ${cart_list.size()}
                        </p>
                    </i> 
                </a>

                <%
                    Object obj = session.getAttribute("khachHang");
                    KhachHang kh = null;
                    if (obj != null) {
                        kh = (KhachHang) obj;
                    }
                    if (kh == null) {
                %>
                <a id="dangnhap" class="btn btn-primary ml-4 " style="white-space: nowrap;" href="<%=url%>/View/signin.jsp">
                    Đăng Nhập
                </a>
                <%} else {%>
                <a id="dangnhap" class="btn btn-dark ml-4 " style="white-space: nowrap;" href="signout">
                    Đăng Xuất
                </a>


                <!--                <script>
                                    document.addEventListener("DOMContentLoaded", function () {
                                        const myElement = document.getElementById("dangnhap");
                                        myElement.style.display = "none";
                                    });
                                </script>-->
                <!-- Example single danger button -->
                <!--                <div class="right">
                                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0 bg-infor ">
                                        <li class="nav-item dropdown dropstart"><a
                                                class="nav-link dropdown-toggle" href="#" role="button"
                                                data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
                                                <li><a class="dropdown-item" href="#">Thông báo</a></li>
                                                <li><a class="dropdown-item" href="#">Thay đổi thông tin</a></li>
                                                <li><a class="dropdown-item" href="doimatkhau.jsp">Đổi mật khẩu</a></li>
                                                <li><hr class="dropdown-divider"></li>
                                                <li><a class="dropdown-item" href="signout">Thoát tài khoản</a></li>
                                            </ul></li>
                                    </ul>
                                </div>-->

                <!--                        <div class="row text-center" style="margin-left:3em">
                                            <b class="row" style="white-space: nowrap ;margin:auto">Xin Chào <%= kh.getTenDangNhap()%></b>
                                            <a class="row"  style="white-space: nowrap ;margin:auto;text-decoration: none" href="signout">
                                                Đăng Xuất
                                            </a>
                                        </div>-->
                <%}%>



            </div>

        </div>
    </div>
</nav>