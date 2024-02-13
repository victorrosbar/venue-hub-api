package com.vtech.venuehubapi.repository;

import com.vtech.venuehubapi.model.Address;
import com.vtech.venuehubapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
