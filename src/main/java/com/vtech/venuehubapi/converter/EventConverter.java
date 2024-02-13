package com.vtech.venuehubapi.converter;

import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.dto.EventListResponseDTO;
import com.vtech.venuehubapi.model.Event;
import com.vtech.venuehubapi.model.enums.EventStatus;
import com.vtech.venuehubapi.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventConverter {

    @Autowired
    private static VenueService venueService;

    public static EventDTO toDTO(Event event) {
        if (event == null) {
            return null;
        }

        return EventDTO.builder()
                .id(event.getId())
                .uuid(event.getUuid())
                .title(event.getTitle())
                .description(event.getDescription())
                .status(event.getStatus())
                .date(event.getDate())
                .lineTimeMin(event.getLineTimeMin())
                .lineTimeMax(event.getLineTimeMax())
                .busyLevel(event.getBusyLevel())
                .ticketsUrl(event.getTicketsUrl())
                .exclusive(event.isExclusive())
                .venue(VenueConverter.toDTO(event.getVenue()))
                .userUuid(event.getUserUuid())
                .medias(MediaConverter.toMediaDTOList(event.getMedias()))
                .build();
    }

    public static Event toModel(EventDTO dto) {
        if (dto == null) {
            return null;
        }

        return Event.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .uuid(StringUtils.hasLength(dto.getUuid()) ? dto.getUuid() : null)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(Objects.isNull(dto.getStatus()) ? EventStatus.ACTIVE : dto.getStatus())
                .date(dto.getDate())
                .lineTimeMin(dto.getLineTimeMin())
                .lineTimeMax(dto.getLineTimeMax())
                .busyLevel(dto.getBusyLevel())
                .ticketsUrl(dto.getTicketsUrl())
                .exclusive(dto.getExclusive())
                .userUuid(StringUtils.hasLength(dto.getUserUuid()) ? dto.getUserUuid() : null)
                .venue(VenueConverter.toModel(dto.getVenue()))
                .medias(!Objects.isNull(dto.getMedias()) ? MediaConverter.toMediaList(dto.getMedias()) : null)
                .build();
    }

    public static EventListResponseDTO toEventListResponse(List<Event> events){
        var dtoList = events.stream()
                .map(EventConverter::toDTO)
                .collect(Collectors.toList());
        return EventListResponseDTO.builder().events(dtoList).build();
    }
}
