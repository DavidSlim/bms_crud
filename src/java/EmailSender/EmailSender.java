package EmailSender;

import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named("emailSender")
@ApplicationScoped
public class EmailSender {

    private Properties mail_server_properties;
    private Session get_mail_session;
    private MimeMessage generate_mail_message;

    private final String email_receiver = "aganokid@gmail.com";
    private final String email_sender = "murimi.simiyu@gmail.com";
    private final String email_password = "09061993";
    private final String subject = "AHOLLA AMIGO";

    String email_body = "I want to know if this bullshit of a email sender is working...." + "<br><br>But do i say";

    public void EmailSender() {
        try {

            //Step1
            mail_server_properties = System.getProperties();
            mail_server_properties.put("mail.smtp.port", "587");
            mail_server_properties.put("mail.smtp.auth", "true");
            mail_server_properties.put("mail.smtp.starttls.enable", "true");

            ///Step2
            get_mail_session = Session.getDefaultInstance(mail_server_properties, null);
            generate_mail_message = new MimeMessage(get_mail_session);
            generate_mail_message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_receiver));
            generate_mail_message.addRecipient(Message.RecipientType.CC, new InternetAddress(email_receiver));
            generate_mail_message.setSubject(subject);
            generate_mail_message.setContent(email_body, "text/html");

            Transport transport = get_mail_session.getTransport("smtp");
            transport.connect("smtp.gmail.com", email_sender, email_password);
            transport.sendMessage(generate_mail_message, generate_mail_message.getAllRecipients());
            transport.close();

        } catch (MessagingException ex) {
        }

    }
}
