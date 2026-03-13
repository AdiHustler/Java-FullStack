package com.capgemini.EventManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.EventManagementSystem.entity.Event;
import com.capgemini.EventManagementSystem.entity.EventType;
import com.capgemini.EventManagementSystem.entity.Status;
import com.capgemini.EventManagementSystem.repo.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByEventDateAfter(LocalDate.now());
    }

    public List<Event> getEventsByType(EventType eventType) {
        return eventRepository.findByEventType(eventType);
    }

    public List<Event> searchByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    public Event createEvent(Event event) {
        event.setStatus(Status.SCHEDULED);
        return eventRepository.save(event);
    }

    public Event updateEvent(Integer id, Event event) {
        Event existing = eventRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setTitle(event.getTitle());
        existing.setDescription(event.getDescription());
        existing.setEventType(event.getEventType());
        existing.setLocation(event.getLocation());
        existing.setEventDate(event.getEventDate());
        existing.setStartTime(event.getStartTime());
        existing.setEndTime(event.getEndTime());
        existing.setOrganizerName(event.getOrganizerName());
        existing.setContactPhone(event.getContactPhone());
        return eventRepository.save(existing);
    }

    public Event cancelEvent(Integer id) {
        Event existing = eventRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setStatus(Status.CANCELLED);
        return eventRepository.save(existing);
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

}
