package src;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.net.ssl.*;
public class SendEmail {


  public static void send(String to, String subject, String body) {
    String sender = "jacksonspicer08@gmail.com";
    String senderPassword = "heos svlk zmek fgxn";
    String recipient = to;

    String host = "smtp.gmail.com";
    int port = 587;

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.ssl.trust", host);
    props.put("mail.debug", "true");

    /*props.put("mail.smtp.connectiontimeout", "10000");
    props.put("mail.smtp.timeout", "10000");
    props.put("mail.smtp.writetimeout", "10000");*/

    props.put("mail.smtp.ssl.protocols", "TLSv1.2");

    // Get Session object
    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(sender, senderPassword);
      }
    });

    try {
      // Create a default MimeMessage object
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(sender));

      // Set To: header field of the header.
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

      // Set Subject: header field
      message.setSubject(subject);

      // Now set the actual message
      message.setText(body);

      // Send message
      Transport.send(message);

      System.out.println("Email sent successfully!");

    } catch (MessagingException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
