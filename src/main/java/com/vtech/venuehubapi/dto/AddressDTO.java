package com.vtech.venuehubapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtech.venuehubapi.model.Address;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
public class AddressDTO {

    @Null
    @JsonIgnore
    private Long id;

    private String uuid;

    @NotBlank
    @Size(max = 100)
    private String publicPlace;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 50)
    private String country;

    @NotBlank
    @Size(max = 50)
    private String state;

    @NotBlank
    @Size(max = 10)
    private String zipCode;

    @Null
    @Size(max = 100)
    private String additionalInfo;

    @Null
    private LocalDateTime createdAt;

    @Null
    private LocalDateTime updatedAt;

}
