package com.hotel.hotel.sendContactForm;

import com.hotel.hotel.roomKind.RoomKindRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContactFormController {

    private ContactFormRepository contactFormRepository;

    public ContactFormController(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @PostMapping("/contact")
    public ResponseEntity<?> submitContactForm(@RequestBody ContactFormEntity contactForm)
    {
        ContactFormEntity savedContactForm = contactFormRepository.saveAndFlush(contactForm);
        return new ResponseEntity<>(savedContactForm, HttpStatus.CREATED);
    }
}
