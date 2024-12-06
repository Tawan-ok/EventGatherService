package com.example.EventGather.service.implement;

import com.example.EventGather.model.entity.Event;
import com.example.EventGather.repository.EventRepository;
import com.example.EventGather.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
