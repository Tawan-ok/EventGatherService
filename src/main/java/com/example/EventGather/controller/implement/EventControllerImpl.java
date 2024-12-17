package com.example.EventGather.controller.implement;

import com.example.EventGather.controller.EventController;
import com.example.EventGather.model.entity.Event;
import com.example.EventGather.service.EventService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventControllerImpl implements EventController {

    private final EventService eventService;

    public EventControllerImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<Event> createEvent(Event event) {
        Event response = eventService.createEvent(event);
        return ResponseEntity.ok(response) ;
    }

    @Override
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> response = eventService.getAllEvent();
        return ResponseEntity.ok(response);
    }
}
