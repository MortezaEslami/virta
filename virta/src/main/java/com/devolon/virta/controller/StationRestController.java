package com.devolon.virta.controller;

import com.devolon.virta.service.dto.StationDTO;
import com.devolon.virta.service.iservice.IStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/stations")
public class StationRestController {

    private final IStationService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StationDTO.Info> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<StationDTO.Info>> list(Pageable pageable) {
        return new ResponseEntity<>(service.list(pageable), HttpStatus.OK);
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

}
