package com.vtech.venuehubapi.controller;

import com.vtech.venuehubapi.dto.AddressDTO;
import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.resource.AddressResource;
import com.vtech.venuehubapi.resource.EventResource;
import com.vtech.venuehubapi.service.AddressService;
import com.vtech.venuehubapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController implements AddressResource {

    @Autowired
    private AddressService service;

    @Override
    public ResponseEntity<AddressDTO> creates(AddressDTO address, String venueUuid) {

        return null;//service.create(address, venueUuid);
    }

}
