package com.vtech.venuehubapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtech.venuehubapi.model.Address;
import com.vtech.venuehubapi.model.enums.VenueStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class VenueDTO {

    @JsonIgnore
    private Long id;
    private String uuid;
    private String title;
    private String description;
    private String userUuid;
    private VenueStatus status;
    private AddressDTO address;
    private List<MediaDTO> medias;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
