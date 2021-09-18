package com.devolon.virta.service;

import com.devolon.virta.exception.ResourceNotFoundException;
import com.devolon.virta.model.Station;
import com.devolon.virta.repository.StationRepository;
import com.devolon.virta.service.dto.StationDTO;
import com.devolon.virta.service.iservice.IStationService;
import com.devolon.virta.service.mapper.StationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StationService implements IStationService {

    private final StationRepository repository;
    private final StationMapper mapper;

    @Override
    public StationDTO.Info get(Long id) {
        return mapper.toDtoInfo(getStation(id));
    }

    @Override
    public Page<StationDTO.Info> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDtoInfo);
    }

    @Override
    public StationDTO.Info create(StationDTO.Create request) {
        return mapper.toDtoInfo(repository.save(mapper.toEntityFromCreate(request)));
    }

    @Override
    public StationDTO.Info update(Long id, StationDTO.Update request) {
        getStation(id);
        Station entity = mapper.toEntityFromUpdate(request);
        entity.setId(id);
        return mapper.toDtoInfo(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        getStation(id);
        repository.deleteById(id);
    }

    private Station getStation(Long id) {
        final Optional<Station> entityById = repository.findById(id);
        return entityById.orElseThrow(() -> new ResourceNotFoundException("No result found for your request id = " + id));
    }
}
