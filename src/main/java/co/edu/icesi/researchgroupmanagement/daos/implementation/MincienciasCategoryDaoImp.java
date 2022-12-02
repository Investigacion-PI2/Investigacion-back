package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.MincienciasCategoryDao;
import co.edu.icesi.researchgroupmanagement.model.MincienciasCategory;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class MincienciasCategoryDaoImp implements MincienciasCategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public MincienciasCategory save(MincienciasCategory mcat) {
		em.persist(mcat);
		return mcat;
	}

	@Override
	public MincienciasCategory update(MincienciasCategory mcat) {
		em.merge(mcat);
		return mcat;
	}

	@Override
	public void delete(MincienciasCategory mcat) {
		em.remove(mcat);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MincienciasCategory> findAll() {
		String query = "SELECT mcat FROM minciencias_category mcat ORDER BY mcat.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public MincienciasCategory findById(Long mcategoryId) {
		return em.find(MincienciasCategory.class, mcategoryId);
	}

	@Override
	public boolean existsById(Long mcategoryId) {
		if (em.find(MincienciasCategory.class, mcategoryId) != null)
			return true;
		return false;
	}

}
