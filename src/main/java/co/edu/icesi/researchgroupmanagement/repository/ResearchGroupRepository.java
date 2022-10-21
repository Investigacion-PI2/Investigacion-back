package co.edu.icesi.researchgroupmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;

@Repository
public interface ResearchGroupRepository extends CrudRepository<ResearchGroup, Long> {

}