package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RgroupLeaderDao;
import co.edu.icesi.researchgroupmanagement.model.RgroupLeader;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RgroupLeaderDaoImp implements RgroupLeaderDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RgroupLeader save(RgroupLeader entity) {
		return update(entity);
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
	public RgroupLeader findById(Long entityId) {
		return em.find(RgroupLeader.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RgroupLeader.class, entityId) != null)
			return true;
		return false;
	}

}
