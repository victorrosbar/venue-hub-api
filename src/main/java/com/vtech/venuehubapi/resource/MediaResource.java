package com.vtech.venuehubapi.resource;

import com.vtech.venuehubapi.dto.MediaDTO;
import com.vtech.venuehubapi.dto.VenueDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/v1/media")
@Api(value = "/v1/media", tags = "Operations about media")
public interface MediaResource {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert new media", response = MediaDTO.class)
    public ResponseEntity<MediaDTO> creates(@RequestBody MediaDTO event);
}
