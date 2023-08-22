<%-- 
    Document   : card
    Created on : Aug 22, 2023, 3:57:00 PM
    Author     : ADMIN
--%>

<%@page import="DataBase.SanPhamDAO"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        SanPhamDAO dao = new SanPhamDAO();
        cartProduct = dao.getCartProduct(cart_list);
        double total = dao.getTotalPrice(cart_list);
        request.setAttribute("cart_list", cart_list);
        request.setAttribute("total", total);
    }
%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
        <title>Card</title>
        <%            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        %>
        <link  type="text/css" rel="stylesheet" href="<%=url%>/CSS/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body class="d-flex flex-column min-vh-100">

        <%@include file="header.jsp" %>


        <div class="flex-grow-1">
            <div class="container my-3">
                <div class="d-flex py-3">
                    <!--     <h3> Total Price: 1000000 VNĐ</h3>
                                        <a class="mx-3 btn-primary" href="#">Checkout</a>-->
                    <div class="d-flex py-3">
                        <h3>Total Price: $ ${(total>0)?total:0} </h3> 
                        <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a>
                    </div>
                </div>
                <table class="table table-light">
                    <thead>
                        <tr class="align-middle">
                            <th class="col-md-3" scope="col">Name</th>
                            <th class="col-md-3" scope="col">Category</th>
                            <th class="col-md-2" scope="col">Price</th>
                            <th class="col-md-2" scope="col" style="width: 30%">Buy Now</th>
                            <th class="col-md-2" scope="col">Cancel</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (cart_list != null) {
                                for (Cart c : cartProduct) {%>

                        <tr class="align-middle ">
                            <td class="col-md-3" ><%= c.getTenSanPham()%></td>
                            <td class="col-md-3"><%= c.getTheLoai().getTenTheLoai()%></td>
                            <td class="col-md-2"><%= c.getGiaBan()%></td>
                            <td class="col-md-2">
                                <form action="order-now" method="post" class="form-inline">
                                    <input type="hidden" name="id" value="<%= c.getMaSanPham()%>" class="form-input">
                                    <div class="form-group d-flex justify-content-between" style="width: 50%">
                                        <a class="btn btn-sm btn-decre" style="color:blue ;--bs-btn-padding-y: 0.5rem" href=""> <i class="fas fa-minus-square" ></i></a>
                                        <input type="text" name="quantity" class="form-control"  value="1" readonly " > 
                                        <a class="btn btn-sm btn-incre" style="color:blue ;--bs-btn-padding-y: 0.5rem" href=""><i class="fas fa-plus-square"></i></a>
                                    </div>
                                </form>
                            </td>
                            <td class="col-md-2"><a href="remove-from-cart?id=1" class="btn btn-sm btn-danger">Remove</a></td>

                        </tr>

                        <%        }
                            }
                        %>


                    </tbody>
                </table>
            </div>    
        </div>



<!--        <footer class="bg-light text-center py-3">
        </footer>-->

    </body>
</html>
