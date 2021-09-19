package com.devolon.virta.service;

import com.devolon.virta.exception.ResourceNotFoundException;
import com.devolon.virta.model.Company;
import com.devolon.virta.model.Station;
import com.devolon.virta.repository.CompanyRepository;
import com.devolon.virta.repository.StationRepository;
import com.devolon.virta.service.dto.StationDTO;
import com.devolon.virta.service.iservice.ICompanyService;
import com.devolon.virta.service.iservice.IStationService;
import com.devolon.virta.service.mapper.StationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StationService implements IStationService {

    private final StationRepository repository;
    private final StationMapper mapper;
    private final ICompanyService companyService;
    private final CompanyRepository companyRepository;

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

    @Override
    public List<StationDTO.Info> getByCompanyId(Long companyId) {
        Company company = companyService.getCompany(companyId);
        List<Long> companies = new ArrayList<>();

        List<Long> childList = companyRepository.findByParentId(companyId);
        companies.addAll(childList);
        int i = childList.size();
        int j = 0;
        while (j < i) {
            childList = companyRepository.findByParentId(companies.get(j));
            i += childList.size();
            companies.addAll(childList);
            j++;
        }
        return mapper.toDtoInfo(repository.findByCompanyIdIn(companies));
    }

    @Override
    public List<StationDTO.Info> getStationsByRadius(StationDTO.Distance distance) {
        return repository.findStationsByDistance(distance.getLatitude(), distance.getLongitude(), distance.getRadius())
                .stream()
                .map(mapper::toDtoInfo)
                .collect(Collectors.toList());

    }

    private Station getStation(Long id) {
        final Optional<Station> entityById = repository.findById(id);
        return entityById.orElseThrow(() -> new ResourceNotFoundException("No result found for your request id = " + id));
    }
}
