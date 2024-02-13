package com.vtech.venuehubapi.model;

import com.vtech.venuehubapi.dto.EventDTO;
import com.vtech.venuehubapi.model.enums.EventStatus;
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
@Table(name = "EVENT")
public class Event {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 50)
    private EventStatus status;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "LINE_TIME_MIN")
    private Integer lineTimeMin;

    @Column(name = "LINE_TIME_MAX")
    private Integer lineTimeMax;

    @Column(name = "BUSY_LEVEL")
    private Integer busyLevel;

    @Column(name = "TICKETS_URL")
    private String ticketsUrl;

    @Column(name = "EXCLUSIVE")
    private Boolean exclusive;

    @Column(name = "USER_UUID")
    private String userUuid;

    @ManyToOne
    @JoinColumn(name = "VENUE_ID")
    private Venue venue;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Media> medias;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public Boolean isExclusive(){
        return exclusive;
    }

}
