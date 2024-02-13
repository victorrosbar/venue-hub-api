package com.vtech.venuehubapi.model;

import com.vtech.venuehubapi.model.enums.VenueStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VENUE")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UUID")
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_UUID")
    private String userUuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 50)
    private VenueStatus status;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Media> medias;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

}
