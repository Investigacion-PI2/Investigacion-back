package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RgroupUserDao;
import co.edu.icesi.researchgroupmanagement.model.RgroupUser;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RgroupUserDaoImp implements RgroupUserDao {

	@PersistenceContext
	private EntityManager em;
	
	// Must use merge because its related model class uses an embedded id.
	@Override
	public RgroupUser save(RgroupUser entity) {
		return update(entity);
	}

	@Override
	public RgroupUser update(RgroupUser entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RgroupUser entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RgroupUser> findAll() {
		String query = "SELECT entity FROM rgroup_users entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RgroupUser findById(Long entityId) {
		return em.find(RgroupUser.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RgroupUser.class, entityId) != null)
			return true;
		return false;
	}

}
