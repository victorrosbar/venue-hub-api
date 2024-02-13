package com.vtech.venuehubapi.service;

import com.vtech.venuehubapi.converter.EventConverter;
import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.dto.EventListResponseDTO;
import com.vtech.venuehubapi.repository.EventRepository;
import com.vtech.venuehubapi.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueService venueService;

    @Transactional
    public ResponseEntity<EventDTO> creates(EventDTO event){
        var venueDto = venueService.creates(event.getVenue()).getBody();
        event.setVenue(venueDto);

        var model = EventConverter.toModel(event);
        var entity = eventRepository.save(model);

        var dto = EventConverter.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    public ResponseEntity<EventListResponseDTO> findByDateRange(LocalDateTime fromDate, LocalDateTime toDate) {
        var events = eventRepository.findByDateBetween(fromDate, toDate);
        var response = EventConverter.toEventListResponse(events);
        return ResponseEntity.ok(response);
    }
}
