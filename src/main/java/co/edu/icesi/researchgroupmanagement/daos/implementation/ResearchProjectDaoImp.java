package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResearchProjectDao;
import co.edu.icesi.researchgroupmanagement.model.ResearchProject;

@Repository
@Scope("singleton")
public class ResearchProjectDaoImp implements ResearchProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResearchProject save(ResearchProject entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ResearchProject update(ResearchProject entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(ResearchProject entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResearchProject> findAll() {
		String query = "SELECT entity FROM research_project entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResearchProject findById(Integer entityId) {
		return em.find(ResearchProject.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(ResearchProject.class, entityId) != null)
			return true;
		return false;
	}

}