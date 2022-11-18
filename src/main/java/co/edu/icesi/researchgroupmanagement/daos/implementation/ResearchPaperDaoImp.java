package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResearchPaperDao;
import co.edu.icesi.researchgroupmanagement.model.ResearchPaper;

@Repository
@Scope("singleton")
public class ResearchPaperDaoImp implements ResearchPaperDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResearchPaper save(ResearchPaper entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ResearchPaper update(ResearchPaper entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(ResearchPaper entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResearchPaper> findAll() {
		String query = "SELECT entity FROM research_paper entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResearchPaper findById(Integer entityId) {
		return em.find(ResearchPaper.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(ResearchPaper.class, entityId) != null)
			return true;
		return false;
	}

}