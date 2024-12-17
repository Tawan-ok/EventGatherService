package com.example.EventGather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.EventGather.model.entity.Event;
import com.example.EventGather.repository.EventRepository;
import com.example.EventGather.service.implement.EventServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventServiceJUnitTest {
    private EventRepository eventRepository;
    private EventService eventService;

    @BeforeEach
    void setUp(){
        eventRepository = Mockito.mock(EventRepository.class);
        eventService = new EventServiceImpl(eventRepository);
    }


    @Test
    void shouldCreateEventSuccessfully(){
        Event event = Event.builder()
            .id("1")
            .title("football")
            .description("find friend to play football together")
            .location("ladpao")
            .date("20/10/2024")
            .time("14.00 - 20.00")
            .organizerId("1")
            .participantIds(List.of("1", "2"))
            .build();

        when(eventRepository.save(event)).thenReturn(event);

        assertEquals("football",event.getTitle());
    }

    @Test
    void shouldGetAllEventSuccessfully(){
        List<Event> events = new ArrayList<>();
        Event event1 = Event.builder()
            .id("1")
            .title("football")
            .description("find friend to play football together")
            .location("ladpao")
            .date("20/10/2024")
            .time("14.00 - 20.00")
            .organizerId("1")
            .participantIds(List.of("1", "2"))
            .build();

        Event event2 = Event.builder()
            .id("2")
            .title("football2")
            .description("find friend to play football together")
            .location("ladpao")
            .date("20/10/2024")
            .time("14.00 - 20.00")
            .organizerId("1")
            .participantIds(List.of("1", "2"))
            .build();

        events.add(event1);
        events.add(event2);

        when(eventRepository.findAll()).thenReturn(events);

        assertEquals(2,events.size());
        assertEquals("football",events.get(0).getTitle());
        assertEquals("football2",events.get(1).getTitle());

    }

}
