package com.devolon.virta.service.mapper;

import com.devolon.virta.model.Station;
import com.devolon.virta.service.dto.StationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StationMapper extends CommonMapper<Station, StationDTO.Info, StationDTO.Create, StationDTO.Update> {


    @Mappings({

            @Mapping(source = "company.name", target = "companyName")
    })
    @Override
    StationDTO.Info toDtoInfo(Station station);


}
