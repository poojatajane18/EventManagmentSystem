package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Event;
import com.example.Entity.RSVP;
import com.example.Models.RSVPStatus;
import com.example.Repositories.EventRepository;
import com.example.Repositories.RSVPRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RSVPService {

    @Autowired
    private RSVPRepository rsvpRepository;

    @Autowired
    private EventRepository eventRepository;

    // Method to create or update an RSVP
    public RSVP createOrUpdateRSVP(Long eventId, String attendeeName, String email, RSVPStatus status) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (!eventOptional.isPresent()) {
            throw new RuntimeException("Event not found with ID: " + eventId);
        }

        Event event = eventOptional.get();
        RSVP rsvp = new RSVP();
        rsvp.setAttendeeName(attendeeName);
        rsvp.setEmail(email);
        rsvp.setStatus(status);
        rsvp.setEvent(event);

        return rsvpRepository.save(rsvp);  // Persist the RSVP to the database
    }

    // Method to get all RSVPs for a specific event
    public List<RSVP> getRSVPsByEvent(Long eventId) {
        return rsvpRepository.findByEventId(eventId);
    }

    // Method to delete an RSVP
    public void deleteRSVP(Long rsvpId) {
        rsvpRepository.deleteById(rsvpId);
    }

    // Method to get a specific RSVP by its ID
    public Optional<RSVP> getRSVPById(Long rsvpId) {
        return rsvpRepository.findById(rsvpId);
    }
}

