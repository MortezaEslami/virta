package com.devolon.virtaconsumer.controller;

import com.devolon.virtaconsumer.service.VirtaStationProxy;
import com.devolon.virtaconsumer.service.dto.StationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/stations")
public class StationRestController {

    private final VirtaStationProxy service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StationDTO.Info> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StationDTO.Info> create(@Validated @RequestBody StationDTO.Create request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StationDTO.Info> update(@PathVariable Long id, @RequestBody StationDTO.Update request) {
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/company/{companyId}")
    public ResponseEntity<List<StationDTO.Info>> getByCompanyId(@PathVariable Long companyId) {
        return new ResponseEntity<>(service.getByCompanyId(companyId), HttpStatus.OK);
    }

    @PostMapping(value = "/distance")
    public ResponseEntity<List<StationDTO.Info>> getStationsByRadius(@RequestBody StationDTO.Distance distance) {
        return new ResponseEntity<>(service.getStationsByRadius(distance), HttpStatus.OK);
    }

}