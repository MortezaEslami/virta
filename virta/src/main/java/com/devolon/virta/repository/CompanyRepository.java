package com.devolon.virta.repository;

import com.devolon.virta.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = " select s.id from Company s where s.parentId =?1")
    List<Long>  findByParentId(Long parentId);
}
