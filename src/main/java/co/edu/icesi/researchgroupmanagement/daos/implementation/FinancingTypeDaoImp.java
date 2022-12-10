package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.FinancingTypeDao;
import co.edu.icesi.researchgroupmanagement.model.FinancingType;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class FinancingTypeDaoImp implements FinancingTypeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public FinancingType save(FinancingType ft) {
		em.persist(ft);
		return ft;
	}

	@Override
	public FinancingType update(FinancingType ft) {
		em.merge(ft);
		return ft;
	}

	@Override
	public void delete(FinancingType ft) {
		em.remove(ft);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FinancingType> findAll() {
		String query = "SELECT ft FROM financing_type ft ORDER BY ft.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public FinancingType findById(Long ftypeId) {
		return em.find(FinancingType.class, ftypeId);
	}

	@Override
	public boolean existsById(Long ftypeId) {
		if (em.find(FinancingType.class, ftypeId) != null)
			return true;
		return false;
	}

}
