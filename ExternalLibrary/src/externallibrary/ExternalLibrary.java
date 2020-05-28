package externallibrary;

//import org.apache.commons.mail.EmailException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.apache.commons.mail.SimpleEmail;
/**
 *
 * @author lenka.wrnatova
 */
public class ExternalLibrary {

    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String myAccountEmail = "lenkawrnatova@gmail.com";
        String password = "xxxxxx";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message sent succesfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("my first email");
            message.setText("hi there, \n look my email!");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(ExternalLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

//        Email email = new SimpleEmail();
//        email.setSmtpPort(587);
//        email.setAuthentication("lenkawrnatova@gmail.com", "heslo");
//        email.setDebug(false);
//        email.setHostName("smtp.gmail.com");
//        email.setFrom("lenkawrnatova@gmail.com");
//        email.setSubject("Hi");
//        email.setMsg("This is a test mail ... :-)");
//        email.addTo("lenkawrnatova@gmail.com");
//        email.setTLS(true);
//        email.send();
//        System.out.println("Mail sent!");
        sendMail("lenkawrnatova@gmail.com");
    }

}
