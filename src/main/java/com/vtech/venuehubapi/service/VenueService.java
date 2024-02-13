package com.vtech.venuehubapi.service;

import com.vtech.venuehubapi.converter.VenueConverter;
import com.vtech.venuehubapi.dto.VenueDTO;
import com.vtech.venuehubapi.model.Venue;
import com.vtech.venuehubapi.repository.VenueRepository;
import io.swagger.models.Response;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private AddressService addressService;

    @Transactional
    public ResponseEntity<VenueDTO> creates(VenueDTO venue){
        var addressDto = addressService.creates(venue.getAddress()).getBody();
        venue.setAddress(addressDto);

        var model = VenueConverter.toModel(venue);
        var entity = venueRepository.save(model);
        var response = VenueConverter.toDTO(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<VenueDTO> findByUuid(String uuid) throws BadHttpRequest {
        var entity = venueRepository.findByUuid(uuid).orElseThrow(BadHttpRequest::new);
        var dto = VenueConverter.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

    public Venue findEntityById(Long venueId) {
        return venueRepository.findById(venueId).orElse(null);
    }

}
