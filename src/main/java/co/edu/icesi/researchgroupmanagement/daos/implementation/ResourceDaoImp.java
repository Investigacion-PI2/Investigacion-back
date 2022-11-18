package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResourceDao;
import co.edu.icesi.researchgroupmanagement.model.Resource;

@Repository
@Scope("singleton")
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
	public Resource findById(Integer entityId) {
		return em.find(Resource.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(Resource.class, entityId) != null)
			return true;
		return false;
	}

}