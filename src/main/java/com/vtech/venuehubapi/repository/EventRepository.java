package com.vtech.venuehubapi.repository;

import com.vtech.venuehubapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
}
