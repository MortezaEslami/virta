package com.devolon.virta.repository;

import com.devolon.virta.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByCompanyIdIn(List<Long> ids);

}
