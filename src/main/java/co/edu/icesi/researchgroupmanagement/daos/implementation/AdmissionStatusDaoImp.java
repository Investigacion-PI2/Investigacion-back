package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.AdmissionStatusDao;
import co.edu.icesi.researchgroupmanagement.model.AdmissionStatus;

@Repository
@Scope("singleton")
public class AdmissionStatusDaoImp implements AdmissionStatusDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AdmissionStatus save(AdmissionStatus as) {
		em.persist(as);
		return as;
	}

	@Override
	public AdmissionStatus update(AdmissionStatus as) {
		em.merge(as);
		return as;
	}

	@Override
	public void delete(AdmissionStatus as) {
		em.remove(as);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdmissionStatus> findAll() {
		String query = "SELECT as FROM admission_status as ORDER BY as.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public AdmissionStatus findById(Integer astatusId) {
		return em.find(AdmissionStatus.class, astatusId);
	}

	@Override
	public boolean existsById(Integer astatusId) {
		if (em.find(AdmissionStatus.class, astatusId) != null)
			return true;
		return false;
	}

}