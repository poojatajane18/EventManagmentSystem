package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendReminder")
    public String sendReminder(
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String messageBody) {
        
        notificationService.sendReminderEmail(email, subject, messageBody);
        return "Reminder email sent successfully!";
    }
}
