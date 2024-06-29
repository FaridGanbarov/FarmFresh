package finalproject.az.farmfresh.services;

public interface EmailService {
    void sendConfirmationEmail(String email, String token);
}
