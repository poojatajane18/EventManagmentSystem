package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.RSVP;

public interface RSVPRepository extends JpaRepository<RSVP, Long>{
	// Method to find RSVPs by event ID
    List<RSVP> findByEventId(Long eventId);
}
