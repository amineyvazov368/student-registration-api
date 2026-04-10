package org.example.studentregistrationapi.service;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String email, String qrPath) {
        System.out.println("--------------- EMAIL SIMULATION ---------------");
        System.out.println("To: " + email);
        System.out.println("Your QR Code: " + qrPath);
        System.out.println("------------------------------------------------");
    }
}
