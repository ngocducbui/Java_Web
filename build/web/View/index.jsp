<%-- 
    Document   : index
    Created on : Aug 17, 2023, 2:41:26 PM
    Author     : ADMIN
--%>

<%@page import="Model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DataBase.SanPhamDAO"%>
<%@page import="Model.KhachHang"%>
<%@page import="Model.SanPham"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        SanPhamDAO dao = new SanPhamDAO();
        cartProduct = dao.getCartProduct(cart_list);
        request.setAttribute("cart_list", cart_list);
    }
%>
<%
    SanPhamDAO dao = new SanPhamDAO();
    List<SanPham> listsp = dao.selectAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <%
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        %>

        <link  type="text/css" rel="stylesheet" href="<%=url%>/CSS/style.css">
        <script type="text/javascript">
            window.onload = function () {
                // Kiểm tra xem có thuộc tính thành công hay không
                var success = <%= request.getAttribute("success")%>;

                if (success) {
                    // Hiển thị pop-up thông báo thành công
                    Swal.fire(
                            'Sign Up Success!',
                            'You need to return to your email to verify your account!',
                            'success'
                            )
                }
            };
        </script>
    </head>

    <body>
        <!-- navbar-->

        <%@include file="header.jsp" %>

        <!-- end-navbar-->
        <!--        Page Content-->
        <div class="container-fluid">
            <div class="row">
                <%@include file="menuleft.jsp" %>
                <!--                menuleft-->

                <div class="col-lg-9 bg-warning2">
                    <div id="carouselExampleIndicators" class="carousel slide ">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner test">
                            <div class="carousel-item active testt">
                                <img src="<%=url%>/image/b.jpg" class="d-block w-100 img-fluid" alt="...">
                            </div>
                            <div class="carousel-item testt">
                                <img src="<%=url%>/image/a.jpg" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item testt">
                                <img src="<%=url%>/image/b.jpg" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>


                    <div class="row mt-5">

                        <%
                            if (!listsp.isEmpty()) {
                                for (SanPham sp : listsp) {%>
                        <div class="col-lg-3 col-md-6 mb-4"  >
                            <div class=" card h-80 w-100">
                                <a href="#">
                                    <img class="card-img-top" src="<%=url%>/image/b.jpg" alt="Card image">
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title text-container">
                                        <a href="#" style="text-decoration: none"  > <%= sp.getTenSanPham()%></a>
                                    </h5>
                                    <h6 class="price mt-4" style="color: red">Price: <%= sp.getGiaBan()%> VNĐ</h6>
                                    <h6 class="category">Category: <%= sp.getTheLoai().getTenTheLoai()%></h6>
                                    <p class="card-title"> Đây là sản phầm mới ra mắt trong năm 2023.</p>
                                    <div class="mt-2 d-flex justify-content-around">
                                        <a href="/TestWeb/AddToCart?id=<%= sp.getMaSanPham()%>" class="btn btn-dark">Add To Card</a>
                                        <a href="#" class="btn btn-primary">Buy Now</a>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted" >
                                        <span class="star">&#9733; &#9733; &#9733; &#9733; &#9734;</span> 
                                    </small>
                                </div>
                            </div>
                        </div>
                        <%        }
                            }
                        %>




                    </div>
                </div> 
            </div>
        </div>


        <!--        End Page Content-->


        <!--        footer-->

        <jsp:include page="footer.jsp"></jsp:include>


        <!--        <div>
                    <form action="login" method="get">
                        <p>
                            Username:
                        </p>
                        <input type="text" name="username" value="name">
                        <p>
                            Password:
                        </p>
                        <input type="password" name="password" value="password">
                        <br>
                        <button type="submit" value="button" >LOGIN</button>
                    </form> 
                </div>-->

    </body>
</html>
