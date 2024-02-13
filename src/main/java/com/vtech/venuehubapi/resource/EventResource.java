package com.vtech.venuehubapi.resource;

import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.dto.EventListResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping(path = "/v1/events")
@Api(value = "/v1/events", tags = "Operations about events")
public interface EventResource {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert new event", response = EventDTO.class)
    ResponseEntity<EventDTO> creates(@RequestBody EventDTO event);

    @GetMapping(value = "/byDateRange", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find all events with filter", response = EventListResponseDTO.class)
    ResponseEntity<EventListResponseDTO> getEventsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate);
}
