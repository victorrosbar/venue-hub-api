package com.vtech.venuehubapi.controller;

import com.vtech.venuehubapi.dto.VenueDTO;
import com.vtech.venuehubapi.resource.VenueResource;
import com.vtech.venuehubapi.service.VenueService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;

@RestController
public class VenueController implements VenueResource {

    @Autowired
    private VenueService service;

    @Override
    public ResponseEntity<VenueDTO> creates(VenueDTO venue) {
        return service.creates(venue);
    }

    @Override
    public ResponseEntity<VenueDTO> findByUuid(String uuid) throws BadHttpRequest {
        return service.findByUuid(uuid);
    }

}
