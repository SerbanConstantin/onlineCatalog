package onlinecatalog.onlinecatalog.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class SendGridEmailService {
    private JavaMailSender javaMailSender;

//    @Autowired
//    private SendGrid sendGridClient;

//    @Autowired
//    public SendGridEmailService(SendGrid sendGridClient) {
//        this.sendGridClient = sendGridClient;
//    }

    @Autowired
    public SendGridEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendMail(Integer userId, String subject, String content) {
//        Optional<Users> users = userRepository.findById(userId);
//        users.ifPresent(u -> {
//            SimpleMailMessage mail = new SimpleMailMessage();
//            mail.setTo(u.getEmailAddress());
//            mail.setFrom("testEmailSDA@gmail.com");
//            mail.setSubject(subject);
//            mail.setText(content);
//            javaMailSender.send(mail);
//        } );
    }

    public void sendHTML(String from, String emailAddress, String please_confirm_account, String linkCreator) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailAddress);
        mail.setFrom(from);
        mail.setSubject(please_confirm_account);
        mail.setText(linkCreator);
        javaMailSender.send(mail);
    }

//    public void sendText(String from, String to, String subject, String body) {
//        Response response = sendEmail(from, to, subject, new Content("text/plain", body));
//        log.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
//                + response.getHeaders());
//    }
//
//    public void sendHTML(String from, String to, String subject, String body) {
//        Response response = sendEmail(from, to, subject, new Content("text/html", body));
//        log.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
//                + response.getHeaders());
//    }
//
//    public void sendHTML(String from, String[] to, String subject, String body) {
//        Response response = sendEmail(from, to, subject, new Content("text/html", body));
//        log.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
//                + response.getHeaders());
//    }
//
//    private Response sendEmail(String from, String to, String subject, Content content) {
//        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
//        Request request = new Request();
//        Response response = null;
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
////            response = this.sendGridClient.api(request);
//        } catch (IOException ex) {
//            log.error(ex.getMessage());
//        }
//        return response;
//    }
//     //send to several recipients
//    private Response sendEmail(String from, String[] to, String subject, Content content) {
//        Mail mail = new Mail();
//        mail.setFrom(new Email(from));
//        mail.setSubject(subject);
//        mail.addContent(content);
//        Personalization personalization = new Personalization();
//        for (String recipient : to) {
//            personalization.addTo(new Email(recipient));
//        }
//        mail.addPersonalization(personalization);
//        Request request = new Request();
//        Response response = null;
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            response = this.sendGridClient.api(request);
//        } catch (IOException ex) {
//            log.error(ex.getMessage());
//        }
//        return response;
//    }
}