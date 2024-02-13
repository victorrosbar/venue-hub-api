package com.vtech.venuehubapi.resource;

import com.vtech.venuehubapi.dto.AddressDTO;
import com.vtech.venuehubapi.dto.VenueDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/v1/addresses")
@Api(value = "/v1/addresses", tags = "Operations about addresses")
public interface AddressResource {
    @PostMapping(path = "/{venueUuid}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert new address", response = AddressDTO.class)
    public ResponseEntity<AddressDTO> creates(@RequestBody AddressDTO address,
                                              @PathVariable("venueUuid") String venueUuid);
}
