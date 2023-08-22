/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class TacGia {

    private String maTacGia;
    private String hoVaTen;
    private Date ngaySinh;
    private String tieuSu;

    public TacGia() {
    }

    public TacGia(String maTacGia, String hoVaTen, Date ngaySinh, String tieuSu) {
        this.maTacGia = maTacGia;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.tieuSu = tieuSu;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TacGia other = (TacGia) obj;
        return Objects.equals(this.maTacGia, other.maTacGia);
//        if (!Objects.equals(this.maTacGia, other.maTacGia)) {
//            return false;
//        }
//        if (!Objects.equals(this.hoVaTen, other.hoVaTen)) {
//            return false;
//        }
//        if (!Objects.equals(this.tieuSu, other.tieuSu)) {
//            return false;
//        }
//        return Objects.equals(this.ngaySinh, other.ngaySinh);
    }

    @Override
    public String toString() {
        return "TacGia{" + "maTacGia=" + maTacGia + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", tieuSu=" + tieuSu + '}';
    }
    
}
