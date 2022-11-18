package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RgroupUserDao;
import co.edu.icesi.researchgroupmanagement.model.RgroupUser;

@Repository
@Scope("singleton")
public class RgroupUserDaoImp implements RgroupUserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RgroupUser save(RgroupUser entity) {
		em.persist(entity);
		return entity;
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
	public RgroupUser findById(Integer entityId) {
		return em.find(RgroupUser.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(RgroupUser.class, entityId) != null)
			return true;
		return false;
	}

}