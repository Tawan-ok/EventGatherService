package com.example.EventGather.service;

import com.example.EventGather.model.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    List<Event> getAllEvent();

}
