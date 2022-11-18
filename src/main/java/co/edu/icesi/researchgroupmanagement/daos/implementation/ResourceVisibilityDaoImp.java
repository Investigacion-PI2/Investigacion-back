package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResourceVisibilityDao;
import co.edu.icesi.researchgroupmanagement.model.ResourceVisibility;

@Repository
@Scope("singleton")
public class ResourceVisibilityDaoImp implements ResourceVisibilityDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResourceVisibility save(ResourceVisibility entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ResourceVisibility update(ResourceVisibility entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(ResourceVisibility entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResourceVisibility> findAll() {
		String query = "SELECT entity FROM resource_visibilities entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResourceVisibility findById(Integer entityId) {
		return em.find(ResourceVisibility.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(ResourceVisibility.class, entityId) != null)
			return true;
		return false;
	}

}