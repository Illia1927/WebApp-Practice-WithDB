package mate.academy.webApp.service;

import mate.academy.webApp.utill.RandomHelper;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    private static final Logger logger = Logger.getLogger(MailService.class);

    public String sendMailWithCode(String userEmail) {
        final String username = "dynamokiev1927illia@gmail.com";
        final String password = "edcwsxqaz22";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test1927kiev@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(userEmail)
            );
            String randomCode = RandomHelper.getRandomCode();
            message.setSubject("Disposable code : ");
            message.setText("your code is : " + randomCode);
            Transport.send(message);
            logger.info("Done");
            return randomCode;
        } catch (MessagingException e) {
            logger.error("can`t send massage", e);
            return "";
        }
    }
}
