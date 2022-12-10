package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.UserTypeDao;
import co.edu.icesi.researchgroupmanagement.model.UserType;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class UserTypeDaoImp implements UserTypeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserType save(UserType ut) {
		em.persist(ut);
		return ut;
	}

	@Override
	public UserType update(UserType ut) {
		em.merge(ut);
		return ut;
	}

	@Override
	public void delete(UserType ut) {
		em.remove(ut);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserType> findAll() {
		String query = "SELECT ut FROM user_types ut ORDER BY ut.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public UserType findById(Long userTypeId) {
		return em.find(UserType.class, userTypeId);
	}

	@Override
	public boolean existsById(Long userTypeId) {
		if (em.find(UserType.class, userTypeId) != null)
			return true;
		return false;
	}

}
