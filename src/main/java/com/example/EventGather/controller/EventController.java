package com.example.EventGather.controller;

import com.example.EventGather.model.entity.Event;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/events")
public interface EventController {

    @Operation(summary = "Create a event")
    @PostMapping()
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event);
}
