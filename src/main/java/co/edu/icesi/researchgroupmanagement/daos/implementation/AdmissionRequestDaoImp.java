package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.AdmissionRequestDao;
import co.edu.icesi.researchgroupmanagement.model.AdmissionRequest;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class AdmissionRequestDaoImp implements AdmissionRequestDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AdmissionRequest save(AdmissionRequest entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public AdmissionRequest update(AdmissionRequest entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(AdmissionRequest entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdmissionRequest> findAll() {
		String query = "SELECT entity FROM admission_request entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public AdmissionRequest findById(Long entityId) {
		return em.find(AdmissionRequest.class, entityId);
	}

	@Override
	public boolean existsById(Long entityId) {
		if (em.find(AdmissionRequest.class, entityId) != null)
			return true;
		return false;
	}

}
