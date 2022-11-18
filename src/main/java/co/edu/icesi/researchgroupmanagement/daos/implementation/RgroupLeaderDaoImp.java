package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RgroupLeaderDao;
import co.edu.icesi.researchgroupmanagement.model.RgroupLeader;

@Repository
@Scope("singleton")
public class RgroupLeaderDaoImp implements RgroupLeaderDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RgroupLeader save(RgroupLeader entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RgroupLeader update(RgroupLeader entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RgroupLeader entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RgroupLeader> findAll() {
		String query = "SELECT entity FROM rgroup_leaders entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RgroupLeader findById(Integer entityId) {
		return em.find(RgroupLeader.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(RgroupLeader.class, entityId) != null)
			return true;
		return false;
	}

}