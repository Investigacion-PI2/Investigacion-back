package co.edu.icesi.researchgroupmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.domain.UserType;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long> {
    
}
