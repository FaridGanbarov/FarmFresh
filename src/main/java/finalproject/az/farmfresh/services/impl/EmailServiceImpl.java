package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendConfirmationEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paige54@ethereal.email");
        message.setTo("paige54@ethereal.email");

        message.setSubject("Confirm email");
        String res="http://localhost:8085/auth/confirm?email="+email+"&token="+token;
        message.setText(res);

        mailSender.send(message);
    }
}
