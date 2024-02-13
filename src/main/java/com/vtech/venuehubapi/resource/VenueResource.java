package com.vtech.venuehubapi.resource;

import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.dto.VenueDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.web.BadHttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;

@RequestMapping(path = "/v1/venues")
@Api(value = "/v1/venues", tags = "Operations about events")
public interface VenueResource {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert new venue", response = VenueDTO.class)
    public ResponseEntity<VenueDTO> creates(@RequestBody VenueDTO event);

    @GetMapping(path = "/{uuid}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find venue by Uuid", response = VenueDTO.class)
    public ResponseEntity<VenueDTO> findByUuid(@PathVariable String uuid) throws BadPaddingException, BadHttpRequest;
}
