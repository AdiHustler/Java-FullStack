package com.capgemini.EventManagementSystem.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.EventManagementSystem.entity.Event;
import com.capgemini.EventManagementSystem.entity.EventType;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByEventDateAfter(LocalDate date);

    List<Event> findByEventType(EventType eventType);

    List<Event> findByTitleContainingIgnoreCase(String title);

}
