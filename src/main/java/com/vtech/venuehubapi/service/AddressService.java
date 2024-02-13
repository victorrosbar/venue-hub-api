package com.vtech.venuehubapi.service;

import com.vtech.venuehubapi.converter.AddressConverter;
import com.vtech.venuehubapi.dto.AddressDTO;
import com.vtech.venuehubapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public ResponseEntity<AddressDTO> creates(AddressDTO address){
        var entity = addressRepository.save(AddressConverter.toModel(address));
        var dto = AddressConverter.toDTO(entity);
        return ResponseEntity.ok(dto);
    }

}
