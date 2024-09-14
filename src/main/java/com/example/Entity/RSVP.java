package com.example.Entity;

import com.example.Models.RSVPStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RSVP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attendeeName;
    private String email;

    @Enumerated(EnumType.STRING) // To store enum as a string in the DB
    private RSVPStatus status; // Use the enum here
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RSVPStatus getStatus() {
		return status;
	}

	public void setStatus(RSVPStatus status) {
		this.status = status;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

    // Getters and Setters
    
}
