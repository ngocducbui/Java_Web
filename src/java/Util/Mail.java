/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import com.sun.javafx.scene.control.skin.FXVK;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class Mail {
    //pass mdtkfzjbhfbjtzwt
    //mail ducbui180801@gmail.com

    static final String from = "ducbui180801@gmail.com";
    static final String password = "mdtkfzjbhfbjtzwt";

    public static boolean sendMail(String to, String noiDung) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //smtp host
        props.put("mail.smtp.port", "587");   //tls 597, ssl465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        //authen
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        //session new
        Session session = Session.getInstance(props, auth);

        //send mail
        //final String to = "ducbui0011@gmail.com";
        //tao tin nhan moi
        MimeMessage message = new MimeMessage(session);

        try {
            //noi dung
            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            //nguoi gui
            message.setFrom(from);
            //nguoi nhan
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            //tieu de
            message.setSubject("Thử NGhiệm Gửi Mail 2");
            //quy dinh ngay gui
            message.setSentDate(new Date());
            //quy dinh phan hoi 
            //message.setReplyTo(null);
            //noi dung chu
            // message.setText("hiii");
            message.setContent(noiDung, "text/HTML; charset=UTF-8");

            //gui mail
            Transport.send(message);
            System.out.println("Gui mail thanh cong");
            return true;
        } catch (MessagingException ex) {
            System.out.println("Gui mail that bai");

            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        Mail.sendMail("ducbui0011@gmail.com", "Dây là nội dung");
    }
}
