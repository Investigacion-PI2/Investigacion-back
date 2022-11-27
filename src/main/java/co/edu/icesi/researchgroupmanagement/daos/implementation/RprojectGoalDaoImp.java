package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectGoalDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectGoal;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RprojectGoalDaoImp implements RprojectGoalDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RprojectGoal save(RprojectGoal entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RprojectGoal update(RprojectGoal entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RprojectGoal entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RprojectGoal> findAll() {
		String query = "SELECT entity FROM rproject_goal entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RprojectGoal findById(Long entityId) {
		return em.find(RprojectGoal.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RprojectGoal.class, entityId) != null)
			return true;
		return false;
	}

}
