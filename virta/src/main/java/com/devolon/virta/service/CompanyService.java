package com.devolon.virta.service;

import com.devolon.virta.exception.ResourceNotFoundException;
import com.devolon.virta.model.Company;
import com.devolon.virta.repository.CompanyRepository;
import com.devolon.virta.service.dto.CompanyDTO;
import com.devolon.virta.service.iservice.ICompanyService;
import com.devolon.virta.service.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService implements ICompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Override
    public CompanyDTO.Info get(Long id) {
        return mapper.toDtoInfo(getCompany(id));
    }

    @Override
    public Page<CompanyDTO.Info> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDtoInfo);
    }

    @Override
    public CompanyDTO.Info create(CompanyDTO.Create request) {
        return mapper.toDtoInfo(repository.save(mapper.toEntityFromCreate(request)));
    }

    @Override
    public CompanyDTO.Info update(Long id, CompanyDTO.Update request) {
        getCompany(id);
        Company entity = mapper.toEntityFromUpdate(request);
        entity.setId(id);
        return mapper.toDtoInfo(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        getCompany(id);
        repository.deleteById(id);
    }

    public Company getCompany(Long id) {
        final Optional<Company> entityById = repository.findById(id);
        return entityById.orElseThrow(() -> new ResourceNotFoundException("No result found for your request id = " + id));
    }
}
