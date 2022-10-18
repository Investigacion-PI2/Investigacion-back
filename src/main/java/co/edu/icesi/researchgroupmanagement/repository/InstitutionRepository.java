package co.edu.icesi.researchgroupmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.Institution;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long> {

}