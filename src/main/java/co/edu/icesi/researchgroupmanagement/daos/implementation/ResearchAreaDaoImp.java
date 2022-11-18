package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResearchAreaDao;
import co.edu.icesi.researchgroupmanagement.model.ResearchArea;

@Repository
@Scope("singleton")
public class ResearchAreaDaoImp implements ResearchAreaDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResearchArea save(ResearchArea entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ResearchArea update(ResearchArea entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(ResearchArea entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResearchArea> findAll() {
		String query = "SELECT entity FROM research_area entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResearchArea findById(Integer entityId) {
		return em.find(ResearchArea.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(ResearchArea.class, entityId) != null)
			return true;
		return false;
	}

}