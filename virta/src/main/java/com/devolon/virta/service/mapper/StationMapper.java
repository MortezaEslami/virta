package com.devolon.virta.service.mapper;

import com.devolon.virta.model.Station;
import com.devolon.virta.service.dto.StationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper extends CommonMapper<Station, StationDTO.Info, StationDTO.Create, StationDTO.Update> {

}
