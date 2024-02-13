package com.vtech.venuehubapi.repository;

import com.vtech.venuehubapi.model.Address;
import com.vtech.venuehubapi.model.Media;
import com.vtech.venuehubapi.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findByUuid(String uuid);
    Optional<Media> findAllByVenueId(String venueId);
    Optional<Media> findAllByEventId(String eventId);
}
