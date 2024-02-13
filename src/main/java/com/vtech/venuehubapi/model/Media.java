package com.vtech.venuehubapi.model;

import com.vtech.venuehubapi.model.enums.MediaStatus;
import com.vtech.venuehubapi.model.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "MEDIA")
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "UUID")
	@Builder.Default
	private String uuid = UUID.randomUUID().toString();

	@Column(name = "URL")
	private String url;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", length = 50)
	private MediaType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 50)
	private MediaStatus status;

	@Column(name = "USER_UUID")
	private String userUuid;

	@ManyToOne
	@JoinColumn(name = "VENUE_ID")
	private Venue venue;

	@ManyToOne
	@JoinColumn(name = "EVENT_ID")
	private Event event;

	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;

	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;
}
