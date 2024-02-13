package com.vtech.venuehubapi.repository;

import com.vtech.venuehubapi.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    Optional<Venue> findByUuid(String uuid);
}
