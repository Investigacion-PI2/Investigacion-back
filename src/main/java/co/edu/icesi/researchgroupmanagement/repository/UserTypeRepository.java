package co.edu.icesi.researchgroupmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.UserTypes;

@Repository
public interface UserTypeRepository extends CrudRepository<UserTypes, Long> {
    
}
