package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectUserDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectUser;

@Repository
@Scope("singleton")
public class RprojectUserDaoImp implements RprojectUserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RprojectUser save(RprojectUser entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RprojectUser update(RprojectUser entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RprojectUser entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RprojectUser> findAll() {
		String query = "SELECT entity FROM rproject_users entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RprojectUser findById(Integer entityId) {
		return em.find(RprojectUser.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(RprojectUser.class, entityId) != null)
			return true;
		return false;
	}

}