package com.devolon.virta.repository;

import com.devolon.virta.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByCompanyIdIn(List<Long> ids);

    @Query(value = "SELECT id,c_name, c_code,N_LATITUDE,N_LONGITUDE, round(distance,2) as n_distance, N_COMPANY_ID, C_COMMENT, D_CREATED_DATE, D_LAST_MODIFIED_DATE, n_version  " +
            "FROM (select id,c_name, c_code,N_LATITUDE,N_LONGITUDE,N_COMPANY_ID, C_COMMENT, D_CREATED_DATE, D_LAST_MODIFIED_DATE, n_version,  " +
            "acos(sin(RADIANS(N_LATITUDE)) * sin(RADIANS(?1)) + cos(RADIANS(?1)) * cos(RADIANS(N_LATITUDE)) * cos(RADIANS(N_LONGITUDE) - (RADIANS(?2)))) * 6371  as distance  FROM tbl_station ) " +
            "where distance < ?3 ORDER BY distance ASC ", nativeQuery = true)
    List<Station> findStationsByDistance(Double latitude, Double longitude, Double radius);

}
