package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.RSVP;
import com.example.Models.RSVPStatus;
import com.example.Service.RSVPService;

import java.util.List;

@RestController
@RequestMapping("/api/rsvps")
public class RSVPController {

    @Autowired
    private RSVPService rsvpService;

    // Endpoint to create/update RSVP for an event
    @PostMapping("/{eventId}")
    public ResponseEntity<RSVP> createRSVP(
        @PathVariable Long eventId,
        @RequestParam String attendeeName,
        @RequestParam String email,
        @RequestParam RSVPStatus status) {
        
        RSVP rsvp = rsvpService.createOrUpdateRSVP(eventId, attendeeName, email, status);
        return ResponseEntity.ok(rsvp);
    }

    // Endpoint to get all RSVPs for a specific event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<RSVP>> getRSVPsByEvent(@PathVariable Long eventId) {
        List<RSVP> rsvps = rsvpService.getRSVPsByEvent(eventId);
        return ResponseEntity.ok(rsvps);
    }

    // Endpoint to delete an RSVP
    @DeleteMapping("/{rsvpId}")
    public ResponseEntity<Void> deleteRSVP(@PathVariable Long rsvpId) {
        rsvpService.deleteRSVP(rsvpId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get a specific RSVP by its ID
    @GetMapping("/{rsvpId}")
    public ResponseEntity<RSVP> getRSVPById(@PathVariable Long rsvpId) {
        return rsvpService.getRSVPById(rsvpId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

