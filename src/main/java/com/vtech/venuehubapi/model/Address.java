package com.vtech.venuehubapi.model;

import com.vtech.venuehubapi.dto.AddressDTO;
import com.vtech.venuehubapi.model.enums.AddressStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "UUID")
	@Builder.Default
	private String uuid = UUID.randomUUID().toString();

	@NotBlank
	@Size(max = 100)
	@Column(name = "PUBLIC_PLACE")
	private String publicPlace;

	@NotBlank
	@Size(max = 100)
	@Column(name = "CITY")
	private String city;

	@NotBlank
	@Size(max = 50)
	@Column(name = "COUNTRY")
	private String country;

	@NotBlank
	@Size(max = 50)
	@Column(name = "STATE")
	private String state;

	@NotBlank
	@Size(max = 10)
	@Column(name = "ZIPCODE")
	private String zipCode;

	@Null
	@Size(max = 100)
	@Column(name = "ADDITIONAL_INFO")
	private String additionalInfo;

	@Size(max = 50)
    @Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 50)
	private AddressStatus status;

	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;

	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;

	public AddressDTO toDto() {
		return AddressDTO.builder()
				.id(id)
				.uuid(uuid)
				.publicPlace(publicPlace)
				.city(city)
				.state(state)
				.country(country)
				.zipCode(zipCode)
				.additionalInfo(additionalInfo)
				.build();
	}
}
