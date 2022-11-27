package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResearchLineDao;
import co.edu.icesi.researchgroupmanagement.model.ResearchLine;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class ResearchLineDaoImp implements ResearchLineDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResearchLine save(ResearchLine entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ResearchLine update(ResearchLine entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(ResearchLine entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResearchLine> findAll() {
		String query = "SELECT entity FROM research_line entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResearchLine findById(Long entityId) {
		return em.find(ResearchLine.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(ResearchLine.class, entityId) != null)
			return true;
		return false;
	}

}
