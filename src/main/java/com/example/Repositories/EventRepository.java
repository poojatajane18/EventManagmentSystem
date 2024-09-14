package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
