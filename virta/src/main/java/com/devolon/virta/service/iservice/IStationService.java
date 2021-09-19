package com.devolon.virta.service.iservice;

import com.devolon.virta.service.dto.StationDTO;

import java.util.List;

public interface IStationService extends IPublicService<StationDTO.Info, Long, StationDTO.Create, StationDTO.Update> {

    List<StationDTO.Info> getByCompanyId(Long companyId);

    List<StationDTO.Info> getStationsByRadius(StationDTO.Distance distance);
}
