package com.vtech.venuehubapi.converter;

import com.vtech.venuehubapi.dto.AddressDTO;
import com.vtech.venuehubapi.model.Address;
import org.springframework.util.StringUtils;

public class AddressConverter {
    public static Address toModel(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        return Address.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .uuid(StringUtils.hasLength(dto.getUuid()) ? dto.getUuid() : null)
                .city(dto.getCity())
                .state(dto.getState())
                .additionalInfo(dto.getAdditionalInfo())
                .zipCode(dto.getZipCode())
                .country(dto.getCountry())
                .publicPlace(dto.getPublicPlace())
                .build();
    }


    public static AddressDTO toDTO(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDTO.builder()
                .id(address.getId())
                .uuid(address.getUuid())
                .publicPlace(address.getPublicPlace())
                .city(address.getCity())
                .country(address.getCountry())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .additionalInfo(address.getAdditionalInfo())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }
}
