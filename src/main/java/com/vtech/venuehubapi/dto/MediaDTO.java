package com.vtech.venuehubapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtech.venuehubapi.model.Event;
import com.vtech.venuehubapi.model.Venue;
import com.vtech.venuehubapi.model.enums.MediaStatus;
import com.vtech.venuehubapi.model.enums.MediaType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MediaDTO {

    @JsonIgnore
    private Long id;
    private String uuid;
    private String url;
    private MediaType type;
    private MediaStatus status;
    private String userUuid;
    private Venue venue;
    private Event event;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
