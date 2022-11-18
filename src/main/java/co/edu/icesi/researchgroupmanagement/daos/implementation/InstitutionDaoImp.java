package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.InstitutionDao;
import co.edu.icesi.researchgroupmanagement.model.Institution;

@Repository
@Scope("singleton")
public class InstitutionDaoImp implements InstitutionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Institution save(Institution i) {
		em.persist(i);
		return i;
	}

	@Override
	public Institution update(Institution i) {
		em.merge(i);
		return i;
	}

	@Override
	public void delete(Institution i) {
		em.remove(i);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Institution> findAll() {
		String query = "SELECT i FROM institution i ORDER BY i.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Institution findById(Integer institutionId) {
		return em.find(Institution.class, institutionId);
	}

	@Override
	public boolean existsById(Integer institutionId) {
		if (em.find(Institution.class, institutionId) != null)
			return true;
		return false;
	}

}