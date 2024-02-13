package com.vtech.venuehubapi.converter;

import com.vtech.venuehubapi.dto.MediaDTO;
import com.vtech.venuehubapi.model.Media;
import org.springframework.util.StringUtils;

import javax.persistence.Converter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MediaConverter {

    public static Media toModel(MediaDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }

        return Media.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .uuid(StringUtils.hasLength(dto.getUuid()) ? dto.getUuid() : null)
                .url(dto.getUrl())
                .type(dto.getType())
                .status(dto.getStatus())
                .userUuid(dto.getUserUuid())
                .venue(dto.getVenue())
                .event(dto.getEvent())
                .build();
    }

    public static MediaDTO toDTO(Media media) {
        if (Objects.isNull(media)) {
            return null;
        }

        return MediaDTO.builder()
                .uuid(media.getUuid())
                .url(media.getUrl())
                .type(media.getType())
                .status(media.getStatus())
                .userUuid(media.getUserUuid())
                .venue(media.getVenue())
                .event(media.getEvent())
                .createdAt(media.getCreatedAt())
                .updatedAt(media.getUpdatedAt())
                .build();
    }

    public static List<MediaDTO> toMediaDTOList(List<Media> medias) {
        return medias != null
                ? medias.stream().map(MediaConverter::toDTO).collect(Collectors.toList())
                : null;
    }

    public static List<Media> toMediaList(List<MediaDTO> mediaDTOs) {
        return mediaDTOs != null
                ? mediaDTOs.stream().map(MediaConverter::toModel).collect(Collectors.toList())
                : null;
    }
}
