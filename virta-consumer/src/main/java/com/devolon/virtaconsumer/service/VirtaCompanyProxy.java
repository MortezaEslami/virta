package com.devolon.virtaconsumer.service;

import com.devolon.virtaconsumer.service.dto.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "company-proxy", url = "localhost:8080/virta/api/v1/companies")
public interface VirtaCompanyProxy {

    @GetMapping("/{id}")
    CompanyDTO.Info get(@PathVariable Long id);

    @PostMapping
    CompanyDTO.Info create(@Validated @RequestBody CompanyDTO.Create request);

    @PutMapping(value = "/{id}")
    CompanyDTO.Info update(@PathVariable Long id, @RequestBody CompanyDTO.Update request);

    @DeleteMapping(value = "/{id}")
    Void delete(@PathVariable Long id);


}
