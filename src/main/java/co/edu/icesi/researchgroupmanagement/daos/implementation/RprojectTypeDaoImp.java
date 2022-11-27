package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectTypeDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectType;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RprojectTypeDaoImp implements RprojectTypeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RprojectType save(RprojectType entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RprojectType update(RprojectType entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RprojectType entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RprojectType> findAll() {
		String query = "SELECT entity FROM rproject_types entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RprojectType findById(Long entityId) {
		return em.find(RprojectType.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RprojectType.class, entityId) != null)
			return true;
		return false;
	}

}
