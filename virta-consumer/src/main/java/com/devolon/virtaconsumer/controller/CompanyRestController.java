package com.devolon.virtaconsumer.controller;

import com.devolon.virtaconsumer.service.VirtaCompanyProxy;
import com.devolon.virtaconsumer.service.dto.CompanyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/companies")
public class CompanyRestController {

    private final VirtaCompanyProxy service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO.Info> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO.Info> create(@Validated @RequestBody CompanyDTO.Create request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO.Info> update(@PathVariable Long id, @RequestBody CompanyDTO.Update request) {
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
