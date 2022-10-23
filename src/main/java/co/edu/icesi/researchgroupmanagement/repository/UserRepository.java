package co.edu.icesi.researchgroupmanagement.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
