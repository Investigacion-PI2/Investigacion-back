package co.edu.icesi.researchgroupmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.MincienciasCategory;

@Repository
public interface MinCienciasCategoryRepository extends CrudRepository<MincienciasCategory, Long> {

}