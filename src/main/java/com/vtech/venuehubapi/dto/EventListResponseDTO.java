package com.vtech.venuehubapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EventListResponseDTO {

    private List<EventDTO> events;
}
