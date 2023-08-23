/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class OrderModel extends SanPham {

    private int orderId;
    private String uId;
    private int quanity;
    private String date;

    public OrderModel() {
    }

    public OrderModel(int orderId, String uId, int quanity, String date) {
        this.orderId = orderId;
        this.uId = uId;
        this.quanity = quanity;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", uId=" + uId + ", quanity=" + quanity + ", date=" + date + '}';
    }

}
