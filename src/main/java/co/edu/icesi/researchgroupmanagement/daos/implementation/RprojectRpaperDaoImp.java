package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectRpaperDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectRpaper;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class RprojectRpaperDaoImp implements RprojectRpaperDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RprojectRpaper save(RprojectRpaper entity) {
		return update(entity);
	}

	@Override
	public RprojectRpaper update(RprojectRpaper entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(RprojectRpaper entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RprojectRpaper> findAll() {
		String query = "SELECT entity FROM rproject_rpapers entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public RprojectRpaper findById(Long entityId) {
		return em.find(RprojectRpaper.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(RprojectRpaper.class, entityId) != null)
			return true;
		return false;
	}

}
