package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResourceDao;
import co.edu.icesi.researchgroupmanagement.model.Resource;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class ResourceDaoImp implements ResourceDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Resource save(Resource entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Resource update(Resource entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(Resource entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Resource> findAll() {
		String query = "SELECT entity FROM resource entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Resource findById(Long entityId) {
		return em.find(Resource.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(Resource.class, entityId) != null)
			return true;
		return false;
	}

}
