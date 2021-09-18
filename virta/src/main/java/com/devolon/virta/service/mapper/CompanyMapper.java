package com.devolon.virta.service.mapper;

import com.devolon.virta.model.Company;
import com.devolon.virta.service.dto.CompanyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends CommonMapper<Company, CompanyDTO.Info, CompanyDTO.Create, CompanyDTO.Update> {

}
