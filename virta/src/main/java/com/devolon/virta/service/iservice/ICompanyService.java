package com.devolon.virta.service.iservice;

import com.devolon.virta.model.Company;
import com.devolon.virta.service.dto.CompanyDTO;

public interface ICompanyService extends IPublicService<CompanyDTO.Info, Long, CompanyDTO.Create, CompanyDTO.Update> {

    Company getCompany(Long id);
}
