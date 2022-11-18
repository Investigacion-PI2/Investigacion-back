package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.FinancingSourceDao;
import co.edu.icesi.researchgroupmanagement.model.FinancingSource;

@Repository
@Scope("singleton")
public class FinancingSourceDaoImp implements FinancingSourceDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public FinancingSource save(FinancingSource fs) {
		em.persist(fs);
		return fs;
	}

	@Override
	public FinancingSource update(FinancingSource fs) {
		em.merge(fs);
		return fs;
	}

	@Override
	public void delete(FinancingSource fs) {
		em.remove(fs);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FinancingSource> findAll() {
		String query = "SELECT fs FROM financing_source fs ORDER BY fs.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public FinancingSource findById(Integer fsourceId) {
		return em.find(FinancingSource.class, fsourceId);
	}

	@Override
	public boolean existsById(Integer fsourceId) {
		if (em.find(FinancingSource.class, fsourceId) != null)
			return true;
		return false;
	}

}