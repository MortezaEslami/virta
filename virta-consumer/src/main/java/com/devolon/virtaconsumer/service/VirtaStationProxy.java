package com.devolon.virtaconsumer.service;

import com.devolon.virtaconsumer.service.dto.StationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "station-proxy", url = "localhost:8080/virta/api/v1/stations")
public interface VirtaStationProxy {

    @GetMapping("/{id}")
    StationDTO.Info get(@PathVariable Long id);

    @PostMapping
    StationDTO.Info create(@Validated @RequestBody StationDTO.Create request);

    @PutMapping(value = "/{id}")
    StationDTO.Info update(@PathVariable Long id, @RequestBody StationDTO.Update request);

    @DeleteMapping(value = "/{id}")
    Void delete(@PathVariable Long id);

    @GetMapping(value = "/company/{companyId}")
    List<StationDTO.Info> getByCompanyId(@PathVariable Long companyId);

    @PostMapping(value = "/distance")
    List<StationDTO.Info> getStationsByRadius(@RequestBody StationDTO.Distance distance);

}
