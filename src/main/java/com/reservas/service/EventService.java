package com.reservas.service;

import com.reservas.dto.CreateEventRequest;
import com.reservas.dto.EventResponse;
import com.reservas.entity.Event;
import com.reservas.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public EventResponse createEvent(CreateEventRequest request) {
        Event event = new Event(
                request.getName(),
                request.getEventDate(),
                request.getTotalTickets(),
                request.getPrice()
        );
        Event savedEvent = eventRepository.save(event);
        return convertToResponse(savedEvent);
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado"));
    }

    private EventResponse convertToResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getName(),
                event.getEventDate(),
                event.getTotalTickets(),
                event.getAvailableTickets(),
                event.getPrice()
        );
    }
}
