package com.vtech.venuehubapi.controller;

import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.dto.EventListResponseDTO;
import com.vtech.venuehubapi.resource.EventResource;
import com.vtech.venuehubapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EventController implements EventResource {

    @Autowired
    private EventService service;

    @Override
    public ResponseEntity<EventDTO> creates(EventDTO event) {
        return service.creates(event);
    }

    @Override
    public ResponseEntity<EventListResponseDTO> getEventsByDateRange(LocalDateTime fromDate, LocalDateTime toDate) {
        return service.findByDateRange(fromDate, toDate);
    }


}
