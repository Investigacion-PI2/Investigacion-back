package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectStatusDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectStatus;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RprojectStatusDaoImp implements RprojectStatusDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RprojectStatus save(RprojectStatus entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RprojectStatus update(RprojectStatus entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RprojectStatus entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RprojectStatus> findAll() {
		String query = "SELECT entity FROM rproject_status entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RprojectStatus findById(Long entityId) {
		return em.find(RprojectStatus.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RprojectStatus.class, entityId) != null)
			return true;
		return false;
	}

}
