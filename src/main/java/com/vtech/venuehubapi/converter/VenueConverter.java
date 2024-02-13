package com.vtech.venuehubapi.converter;

import com.vtech.venuehubapi.dto.VenueDTO;
import com.vtech.venuehubapi.model.Venue;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static com.vtech.venuehubapi.converter.MediaConverter.toMediaDTOList;
import static com.vtech.venuehubapi.converter.MediaConverter.toMediaList;

public class VenueConverter {

    public static VenueDTO toDTO(Venue venue) {
        if (Objects.isNull(venue)) {
            return null;
        }

        return VenueDTO.builder()
                .id(venue.getId())
                .uuid(venue.getUuid())
                .title(venue.getTitle())
                .description(venue.getDescription())
                .userUuid(venue.getUserUuid())
                .status(venue.getStatus())
                .address(AddressConverter.toDTO(venue.getAddress()))
                .medias(toMediaDTOList(venue.getMedias()))
                .createdAt(venue.getCreatedAt())
                .updatedAt(venue.getUpdatedAt())
                .build();
    }

    public static Venue toModel(VenueDTO dto) {
        if (dto == null) {
            return null;
        }

        return Venue.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .uuid(StringUtils.hasLength(dto.getUuid()) ? dto.getUuid() : null)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .userUuid(StringUtils.hasLength(dto.getUserUuid()) ? dto.getUserUuid() : null)
                .status(dto.getStatus())
                .address(AddressConverter.toModel(dto.getAddress()))
                .medias(!Objects.isNull(dto.getMedias()) ? MediaConverter.toMediaList(dto.getMedias()) : null)
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
