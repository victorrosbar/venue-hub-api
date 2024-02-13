package com.vtech.venuehubapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtech.venuehubapi.model.Event;
import com.vtech.venuehubapi.model.enums.EventStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class EventDTO {

    @JsonIgnore
    private Long id;
    private String uuid;
    private String title;
    private String description;
    private EventStatus status;
    private LocalDateTime date;
    private Integer lineTimeMin;
    private Integer lineTimeMax;
    private Integer busyLevel;
    private String ticketsUrl;
    private Boolean exclusive;
    private VenueDTO venue;
    private String userUuid;
    private List<MediaDTO> medias;

    public Boolean isExclusive(){
        return exclusive;
    }
}
